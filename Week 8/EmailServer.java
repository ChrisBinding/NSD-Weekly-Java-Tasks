//*** Supplied code ***

import java.net.*;
import java.util.*;
import java.io.*;

public class EmailServer
{
	private static ServerSocket serverSocket;
	private static final String CLIENT1 = "Dave";
	private static final String CLIENT2 = "Karen";
	private static final int MAX_MESSAGES = 10;
	private static String[] mailbox1 = new String[MAX_MESSAGES];
	private static String[] mailbox2 = new String[MAX_MESSAGES];
	private static int messagesInBox1 = 0;
	private static int messagesInBox2 = 0;

	public static void main(String[] args) throws IOException
	{
		final int PORT = 1234;

		System.out.println("Opening connection...\n");

		try
		{
			serverSocket = new ServerSocket(PORT);
		}
		catch(IOException ioEx)
		{
			System.out.println("Unable to attach to port!");
			System.exit(1);
		}

		do
		{
			try
			{
				supplyEmail();
			}
			catch (InvalidClientException icException)
			{
				System.out.println("Error: " + icException);
			}
			catch (InvalidRequestException irException)
			{
				System.out.println("Error: " + irException);
			}
		}while (true);
	}

	private static void supplyEmail() throws IOException,
				InvalidClientException, InvalidRequestException
	{
		Socket socket = serverSocket.accept();

		Scanner input = new Scanner(socket.getInputStream());
		PrintWriter output = new PrintWriter(
								socket.getOutputStream(),true);

		String name = input.nextLine();
		String sendRead = input.nextLine();
		if (!name.equals(CLIENT1) && !name.equals(CLIENT2))
		{
			socket.close();
			throw new InvalidClientException();
		}

		while (!sendRead.equals("quit"))
		{
			if (!sendRead.equals("send")
								&& !sendRead.equals("read"))
			{
				socket.close();
				throw new InvalidRequestException();
			}

			System.out.println("\n" + name + " "
								+ sendRead + "ing mail...");

			if (name.equals(CLIENT1))
			{
				if (sendRead.equals("send"))
				{
					doSend(mailbox2,messagesInBox2,input);
					if (messagesInBox2<MAX_MESSAGES)
						messagesInBox2++;
				}
				else
				{
					doRead(mailbox1,messagesInBox1,output);
					messagesInBox1 = 0;
				}
			}
			else	//From CLIENT2.
			{
				if (sendRead.equals("send"))
				{
					doSend(mailbox1,messagesInBox1,input);
					if (messagesInBox1<MAX_MESSAGES)
						messagesInBox1++;
				}
				else
				{
					doRead(mailbox2,messagesInBox2,output);
					messagesInBox2 = 0;
				}
			}

			name = input.nextLine();
			sendRead = input.nextLine();
			if (!name.equals(CLIENT1) && !name.equals(CLIENT2))
			{
				socket.close();
				throw new InvalidClientException();
			}
		}

		socket.close();
	}

	private static void doSend(String[] mailbox,
						int messagesInBox, Scanner input)
	{
		//Client has requested 'sending', so server must
		//read message from this client and then place message
		//into message box for other client (if there is room).

		String message = input.nextLine();
		if (messagesInBox == MAX_MESSAGES)
			System.out.println("\nMessage box full!");
		else
			mailbox[messagesInBox] = message;
	}

	private static void doRead(String[] mailbox,
					int messagesInBox, PrintWriter output)
	{
		//Client has requested 'reading', so server must
		//read messages from this client's message box and
		//then send those messages to the client.

		System.out.println("\nSending "
							+ messagesInBox + " message(s).\n");
		output.println(messagesInBox);
		for (int i=0; i<messagesInBox; i++)
			output.println(mailbox[i]);
	}
}

class InvalidClientException extends Exception
{
	public InvalidClientException()
	{
		super("Invalid client name!");
	}

	public InvalidClientException(String message)
	{
		super(message);
	}
}

class InvalidRequestException extends Exception
{
	public InvalidRequestException()
	{
		super("Invalid request!");
	}

	public InvalidRequestException(String message)
	{
		super(message);
	}
}
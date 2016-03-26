import java.io.*;
import java.net.*;
import java.util.*;

public class ConsumerClient
{

	public static void main(String[] args)
								throws IOException
	{
		InetAddress host = null;
		final int PORT = 1234;
		Socket socket;
		Scanner networkInput,keyboard;
		PrintWriter output;

		try
		{
			host = InetAddress.getLocalHost();
		}
		catch(UnknownHostException uhEx)
		{
			System.out.println("\nHost ID not found!\n");
		}

		socket = new Socket(host, PORT);
		networkInput = new Scanner(socket.getInputStream());
		output = new PrintWriter(
							socket.getOutputStream(),true);

		keyboard = new Scanner(System.in);

		String message, response;

		do
		{
			System.out.print("\nEnter 1 for resource or 0 to quit: ");
			message = keyboard.nextLine();
			output.println(message);
			if (message.equals("1"))
			{
				response = networkInput.nextLine();
				System.out.println("\n" + response);
			}
			else if (!message.equals("1") && !message.equals("0"))
			{
				System.out.print("\n*** INVALID! ***\n\n");
			}
		}while (!message.equals("0"));

		try
		{
			System.out.println("\nClosing down connection...\n");
			socket.close();
		}
		catch(IOException ioEx)
		{
			System.out.println("\n* Disconnection problem! *\n");
		}
	}
}



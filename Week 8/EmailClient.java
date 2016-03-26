import java.net.*;
import java.util.*;
import java.io.*;

public class EmailClient
{
	private static InetAddress host;
	private static final int PORT = 1234;
	private static String name;
	private static Scanner networkInput,userEntry;
	private static PrintWriter networkOutput;

	public static void main(String[] args)
									throws IOException
	{
		try
		{
			host = InetAddress.getLocalHost();
		}
		catch(UnknownHostException uhEx)
		{
			System.out.println("Host ID not found!");
			System.exit(1);
		}

		userEntry = new Scanner(System.in);
		do
		{
			System.out.print(
						"\nEnter name ('Dave' or 'Karen'): ");
			name = userEntry.nextLine();
		}while (!name.equals("Dave") && !name.equals("Karen"));

		useEmail();
	}

	private static void useEmail() throws IOException
	{
		String option;

		/***************************************************

		CREATE A SOCKET AND SET UP INPUT AND OUTPUT STREAMS,

		***************************************************/
		
		Socket socket = null;
		
		socket = new Socket(host, PORT);
		networkInput = new Scanner(socket.getInputStream());
		networkOutput = new PrintWriter(socket.getOutputStream(),true);
			
		//Set up Scanner for keyboard entry...
		userEntry = new Scanner(System.in);
			
		do
		{
			do //Loop to validate user's entry --- does nothing else!
			{

			/**************************************************
			ACCEPT THE USER'S REQUEST ('s', 'r' OR 'q')
			**************************************************/
				
			System.out.print("Enter request ('s', 'r' OR 'q'): ");
			option = userEntry.nextLine();

			}while (!option.equals("s") && !option.equals("r") && !option.equals("q"));

			/**************************************************
			IF OPTION IS 's' OR 'r', CALL UP THE APPROPRIATE
			METHOD (doSend OR doRead).
			**************************************************/
			
			if (option.equals("s"))
			{
				doSend();
			}
			
			if (option.equals("r"))
			{
				doRead();
			}

		}while (!option.equals("q"));
		
		/**************************************************
		SEND USER'S NAME TO SERVER,	FOLLOWED BY 'quit',
		AND THEN CLOSE THE LINK.
		**************************************************/
		
		networkOutput.println(name);
		networkOutput.println("quit");
		System.out.println("\n* Closing connection... *");
		socket.close();	
	}

	private static void doSend()
	{
		System.out.println("\nEnter 1-line message: ");
		String message = userEntry.nextLine();
		networkOutput.println(name);
		networkOutput.println("send");
		networkOutput.println(message);
	}

	private static void doRead()
	{

		/***************************

		BODY OF THIS METHOD REQUIRED

		***************************/
		String messageData, redundent;
		int noOfMessages;
		
		networkOutput.println(name);
		networkOutput.println("read");
		
		noOfMessages = networkInput.nextInt();
		System.out.println("\nNumber of Messages: " + noOfMessages);
		
		redundent = networkInput.nextLine();
		
		for(int x=0; x < noOfMessages; x++)
		{
			messageData = networkInput.nextLine();
			System.out.println("\nMessage Data" + (x+1) + ": " + messageData);
		}
	}
}
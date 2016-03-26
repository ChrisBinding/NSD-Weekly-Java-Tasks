import java.io.*;
import java.net.*;
import java.util.*;

public class ResourceServer
{
	public static void main(String[] args)
									throws IOException
	{
		ServerSocket serverSocket = null;
		final int PORT = 1234;
		Resource item = null;
		Producer producer = null;
		Socket client = null;
		ClientHandler handler = null;

		try
		{
			serverSocket = new ServerSocket(PORT);
		}
		catch (IOException ioEx)
		{
			System.out.println("\nUnable to set up port!");
			System.exit(1);
		}

		item = new Resource(1);	//Start level = 1.

		producer = new Producer(item);
		producer.start();

		do
		{
			//Wait for client...
			client = serverSocket.accept();

			System.out.println("\nNew client accepted.\n");
			handler = new ClientHandler(client,item);
			handler.start();
		}while (true);
	}
}

class Producer extends Thread
{
	private Resource item;

	public Producer(Resource resource)
	{
		item = resource;
	}

	public void run()
	{
		int pause;
		Random randomInt = new Random();
		int newLevel;

		do
		{
			try
			{
				newLevel = item.addOne();	//Add 1 to level.
				System.out.println(
					"<Producer> New level: " + newLevel);
				pause = randomInt.nextInt(5000);
				sleep(pause);
			}
			catch (InterruptedException intEx)
			{
				System.out.println(intEx.toString());
				System.exit(1);
			}
		}while (true);
	}
}

class Resource
{
	private int currentLevel;

	public Resource(int startLevel)
	{
		currentLevel = startLevel;
	}

	public int getLevel()
	{
		return currentLevel;
	}

	public synchronized int addOne()
	{
		try
		{
			while (currentLevel > 4)
				wait();
			currentLevel++;
			notifyAll();
		}
		catch (InterruptedException intEx)
		{
			System.out.println(intEx.toString());
		}
		return currentLevel;
	}

	public synchronized int takeOne()
	{
		try
		{
			while (currentLevel < 1)
				wait();
			currentLevel--;
			notifyAll();
		}
		catch (InterruptedException intEx)
		{
			System.out.println(intEx.toString());
		}
		return currentLevel;
	}
}

class ClientHandler extends Thread
{
	private Socket client;
	private Resource item;
	private Scanner input;
	private PrintWriter output;

	public ClientHandler(Socket socket,
				Resource resource) throws IOException
	{
		client = socket;
		item = resource;

		input = new Scanner(client.getInputStream());
		output = new PrintWriter(
						client.getOutputStream(),true);
	}

	public void run()
	{
		int request, newLevel;

		do
		{
			request = input.nextInt();
			if (request==1)
			{
				newLevel = item.takeOne();
							//If none available,
							//wait until resource(s)
							//available (and thread is at
							//front of thread queue).
				System.out.println("<Producer> New level: " + newLevel);
				output.println("Request granted.");
			}
		}while (request!=0);

		try
		{
			System.out.println("Closing down connection...");
			client.close();
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();
		}
	}
}


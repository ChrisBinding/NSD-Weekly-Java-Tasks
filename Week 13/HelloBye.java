import java.util.Random;

public class HelloBye
{
	public static void main(String[] args)
	{
		Hello hello = new Hello();
		Goodbye goodbye = new Goodbye();
		
		Thread thread1 = new Thread(hello);
		Thread thread2 = new Thread(goodbye);
		
		thread1.start();
		thread2.start();
	}
}

class Hello implements Runnable
{
	public void run()
	{
		int  pause;
		Random randomInt = new Random();

		for (int i=0; i<10; i++)
		{
			try
			{
				pause = randomInt.nextInt(2000);
				Thread.sleep(pause);
				System.out.println("Hello!");
			}
			catch (InterruptedException intEx)
			{
				System.out.println(intEx);
			}
		}
	}
}

class Goodbye implements Runnable
{
	int  pause;
	Random randomInt = new Random();

	public void run()
	{
		for (int i=0; i<10; i++)
		{
			try
			{
				pause = randomInt.nextInt(2000);
				Thread.sleep(pause);
				System.out.println("Goodbye!");
			}
			catch (InterruptedException intEx)
			{
				System.out.println(intEx);
			}
		}
	}
}
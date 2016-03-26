import java.util.Random;

public class HelloByeRaceStopping
{
	public static Hello hello = new Hello();
	public static Goodbye goodbye = new Goodbye();
	
	public static void main(String[] args)
	{	
		hello.start();
		goodbye.start();
	}
	
	static class Hello extends Thread
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
					return;
				}
			}
			
			goodbye.interrupt();
			System.out.println("Hello Thread Wins!");
		}
	}
	
	static class Goodbye extends Thread
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
					return;
				}
			}
			
			hello.interrupt();
			System.out.println("Goodbye Thread Wins!");
		}
	}
}




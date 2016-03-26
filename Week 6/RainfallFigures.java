import java.util.*;

public class RainfallFigures
{

	public static void main(String[] args) throws CorruptionException
	{
		
		float rainfall = 0;
		int days = 0;
		int input = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter rainfall figures below (Enter a Negative value to quit)");
		System.out.print("\n\nEnter a rainfall integer (mm): ");
		input = keyboard.nextInt();
		
		while (input >= 0)
		{
			if (input >= 100)
			{
				throw (new CorruptionException());
			}
			
			days++;
			
			rainfall = (rainfall + input);
			
			System.out.print("Enter a rainfall integer (mm): ");
			input = keyboard.nextInt();	
		}
		
		keyboard.close();
		
		System.out.println("\nNumber of days' data entered by user: " + days);
		if (days > 0)
		{
			System.out.printf("\nMean daily rainfall: " + "%.1f %n", + (rainfall/days));
		}
		else
			System.out.printf("\nNo Mean - No Values Were Entered");
	}

}

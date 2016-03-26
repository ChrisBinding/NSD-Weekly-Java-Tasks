import java.util.*;

public class DivisableBy3WHILE__Week2_Task4 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int integer;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		integer = keyboard.nextInt();
		
		while (integer >= 0)
		{
			if (integer%3 == 0)
				System.out.println("Your entered number '" + integer + "' IS exactly divisable by 3");
			else
				System.out.println("Your entered number '" + integer + "' IS NOT exactly divisable by 3");	
			
			System.out.print("\nEnter an integer: ");
			integer = keyboard.nextInt();
		}

		keyboard.close();
	}

}

import java.util.*;

public class Week2_Task2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int integer;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		integer = keyboard.nextInt();
		
		keyboard.close();
		
		if (integer%3 == 0)
			System.out.println("Your entered number '" + integer 
										+ "' IS exactly divisible by 3");
		else
			System.out.println("Your entered number '" + integer 
										+ "' IS NOT exactly divisible by 3");
	}

}
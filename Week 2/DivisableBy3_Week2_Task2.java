import java.util.*;

public class DivisableBy3_Week2_Task2 
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
			System.out.println("Your entered number '" + integer + "' IS exactly divisable by 3");
		else
			System.out.println("Your entered number '" + integer + "' IS NOT exactly divisable by 3");
	}

}

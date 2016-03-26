import java.util.*;

public class Week2_Task3 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int integer;
		
		Scanner keyboard = new Scanner(System.in);
		
		for(int count=1; count<6; count++)
		{
			System.out.print("Enter an integer: ");
			integer = keyboard.nextInt();
		
			if (integer%3 == 0)
				System.out.println("Your entered number '" + integer + "' IS exactly divisable by 3");
			else
				System.out.println("Your entered number '" + integer + "' IS NOT exactly divisable by 3");
		}
		
		keyboard.close();
	}

}
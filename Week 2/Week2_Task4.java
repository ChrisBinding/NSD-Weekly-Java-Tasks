import java.util.*;

public class Week2_Task4 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int integer;
		String option;
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			System.out.print("\nEnter an integer: ");
			integer = keyboard.nextInt();
		
			if (integer%3 == 0)
				System.out.println("Your entered number '" 
									+ integer + "' IS exactly divisable by 3");
			else
				System.out.println("Your entered number '" 
									+ integer + "' IS NOT exactly divisable by 3");
			
			System.out.print("\nDo you wish to do this again (y/n)?: ");
			option = keyboard.next();
			
		}while (option.equals("Y") || option.equals("y"));
		
		keyboard.close();
	}

}
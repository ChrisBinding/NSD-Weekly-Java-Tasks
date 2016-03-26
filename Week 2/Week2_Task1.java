import java.util.*;


public class Week2_Task1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int integer1, integer2, total;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		integer1 = keyboard.nextInt();
		
		System.out.print("Enter another integer: ");
		integer2 = keyboard.nextInt();
		
		keyboard.close();
		
		total = integer1 + integer2;
		
		System.out.println("The sum of the entered integers is: " + total);
	}

}

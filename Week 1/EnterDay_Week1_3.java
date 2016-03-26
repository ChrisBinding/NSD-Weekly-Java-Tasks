import java.util.*;

public class EnterDay_Week1_3 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String day;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter the day of the week: ");
		
		day = keyboard.next();
		keyboard.close();
		
		System.out.println("Happy " + day + "!"); 
	}

}

import java.util.*;

public class Week2_Task7 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String colour;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a colour: ");
		colour = keyboard.nextLine();
		
		keyboard.close();
		
		switch (colour)
		{
			case "red":		System.out.print("Red");
							break;
			case "green":	System.out.print("Green");
							break;
			case "blue": 	System.out.print("Blue");
							break;
				
			default: System.out.println("Invalid entry!");
		
		}
	}

}

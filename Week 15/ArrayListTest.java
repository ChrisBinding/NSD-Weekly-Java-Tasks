import java.util.*;
import personnelPackage.*;

public class ArrayListTest
{
	static ArrayList<Personnel> staffList = new ArrayList<Personnel>();
	
	static Personnel[] staff =
			{new Personnel(123456,"Smith","John"),
			 new Personnel(234567,"Jones","Sally Ann"),
			 new Personnel(999999,"Black","James Paul")};
	
	static Scanner keyboard;
	
	static String searchPayrollNo = "";
	
	public static void main(String[] args)
	{
		for (Personnel person:staff)
			staffList.add(person);	
		
		keyboard = new Scanner(System.in);
		
		display();
		
		System.out.print("\n\nEnter Payroll number to remove: ");
		searchPayrollNo = keyboard.nextLine();
		
		while(!searchPayrollNo.equals("0"))
		{
			int returnedArrayPos = 0;
			
			returnedArrayPos = payrollSearch(searchPayrollNo);
		
			if (returnedArrayPos == -1)
			{
				System.out.println("\nERROR - NO EMPLOYEE FOUND WITH THAT PAYROLL NUMBER\n\n");
			}
			else
			{
				staffList.remove(returnedArrayPos);
				System.out.println("\nREMOVED EMPLOYEE WITH PAYROLL NUMBER '" + searchPayrollNo + "'\n\n");
			
			}
			
			display();
			
			System.out.print("\n\nEnter Payroll number to remove (use 0 to exit): ");
			searchPayrollNo = keyboard.nextLine();
	}
		
	System.out.println("\nPROGRAM EXIT");
		
	}
	
	public static void display()
	{
		
		
		
			for (Personnel person : staffList)
			{
				System.out.println("Payroll number: "
									+ person.getPayNum());
				System.out.println("Surname: "
									+ person.getSurname());
				System.out.println("First name(s): "
							+ person.getFirstNames() + "\n");
			}
	
	}
	
	public static int payrollSearch(String searchPayrollNo)
	{
		long search;
		
		search = Long.valueOf(searchPayrollNo);
			
		int arrayPos = 0;
		int returnPos = 10;
		
		for (Personnel person : staffList)
		{
			if (search == person.getPayNum())
			{
				returnPos = arrayPos;
			}
			arrayPos++;
		}
		
		if (returnPos == 10)
		{
			return -1;
		}
		else
		{
			return returnPos;
		}
	}
}
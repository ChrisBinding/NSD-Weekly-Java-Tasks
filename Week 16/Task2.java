import java.util.*;
import java.io.*;

public class Task2
{
	public static void main(String[] args) throws FileNotFoundException
	{	
		File payrollFile = new File("src\\Payroll.txt");
		if (!payrollFile.exists())
		{
			System.out.println("*** File not found! ***");
			System.exit(1);
		}

		Scanner input = new Scanner(payrollFile);
		
		System.out.println("Surname \t\tPayroll No.");
		System.out.println("-------- \t\t----------");
		
		while (input.hasNext())
		{
			System.out.print(input.nextLine() + "\t\t\t");
			if (input.hasNext())
			{
				System.out.print(input.nextLine() + "\n");
			}
		}
		input.close();
	}
}

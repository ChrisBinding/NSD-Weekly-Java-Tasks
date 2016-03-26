import java.util.*;
import java.io.*;

public class Task1
{
	public static void main(String[] args)
						throws FileNotFoundException
	{
		File payroll = new File("C:\\Users\\Chris\\Desktop\\Week17\\Week17\\bin\\payroll.txt");

		if (!payroll.exists())
		{
			System.out.println("\n*** File not found! ***");
			System.exit(1);
		}

		Scanner input = new Scanner(System.in);	// Scanner around System.in
		String surname;
		int payNumber;

		System.out.println("\nSurname		Payroll No.");
		System.out.println("-------		-----------\n");

		while (input.hasNext())
		{
			surname = input.next();
			System.out.print(surname);
			if (input.hasNext())
			{
				payNumber = input.nextInt();
				System.out.print("\t\t" + payNumber);
			}
			System.out.println();
		}
		input.close();

		System.out.println("\n\n");
	}
}

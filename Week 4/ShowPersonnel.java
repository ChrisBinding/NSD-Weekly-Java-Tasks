public class ShowPersonnel 
{
	public static void main(String[] args) 
	{	
		Personnel[] person =
							{
							 new Personnel("John", "Department 1", 123),
							 new Personnel("Sally", "Department 2", 456),
							 new Personnel("Steve", "Department 3", 789)
							};
		
		System.out.print("\nName" + "\t\t\t\t" + "Payroll Number");
		System.out.print("\n-----" + "\t\t\t\t" + "-----");
		
		for (int i=0; i<person.length; i++)
		{
			displayObjects(person[i]);
		}
	}
	
	public static void displayObjects(Personnel person)
	{
		System.out.print("\n" + person.getName() + "\t\t\t\t" + person.getPayrollNum());
	}

}

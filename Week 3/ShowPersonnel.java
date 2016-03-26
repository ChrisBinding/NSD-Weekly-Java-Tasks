public class ShowPersonnel 
{
	public static void main(String[] args) 
	{
		Personnel person1 = new Personnel("John", "Department 1", 123);
		Personnel person2 = new Personnel("Sally", "Department 2", 456);
		Personnel person3 = new Personnel("Steve", "Department 3", 789);
		
		System.out.print("\nName" + "\t\t\t\t" + "Payroll Number");
		System.out.print("\n-----" + "\t\t\t\t" + "-----");
		
		displayObjects(person1);
		displayObjects(person2);
		displayObjects(person3);
	}
	
	public static void displayObjects(Personnel person)
	{
		System.out.print("\n" + person.getName() + "\t\t\t\t" + person.getPayrollNum());
	}

}

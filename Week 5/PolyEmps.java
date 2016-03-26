public class PolyEmps 
{

	public static void main(String[] args) 
	{
		Personnel[] employee = new Personnel[2];
		employee[0] = new Manager("Manager 1", "Manager Department", 584, 28215f);
		employee[1] = new Worker("Worker 1", "Worker Department", 784, 37.5f, 8.26f);
		
		System.out.print("\nName" + "\t\t\t\t" + "Annual Income");
		System.out.println("\n-----" + "\t\t\t\t" + "-----");
		
		System.out.printf(employee[0].name + "\t\t\t" + "%.2f %n", 
													employee[0].getAnnualIncome());
		System.out.printf(employee[1].name + "\t\t\t" + "%.2f %n" , 
													employee[1].getAnnualIncome());
	}
}

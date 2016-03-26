public class UseEmpClasses 
{

	public static void main(String[] args) 
	{
		Manager manager = new Manager("Manager 1", "Manager Department", 584, 28215f);
		
		Worker worker = new Worker("Worker 1", "Worker Department", 784, 37.5f, 8.26f);
		
		System.out.print("\nName" + "\t\t\t\t" + "Department" + "\t\t\t\t" + "Salary");
		System.out.println("\n-----" + "\t\t\t\t" + "-----" + "\t\t\t\t\t" + "-----");
		
		System.out.println(manager.getName() + "\t\t\t" + manager.getDept() + "\t\t\t" + "£" + manager.getSalary());
		
		manager.setDept("New Manager Department");
		
		System.out.println("\nNew Department: " + manager.getDept());
		
		System.out.print("\nName" + "\t\t\t\t" + "Department" + "\t\t\t\t" + "Wage");
		System.out.println("\n-----" + "\t\t\t\t" + "-----" + "\t\t\t\t\t" + "-----");
		
		System.out.print(worker.getName() + "\t\t\t" + worker.getDept() + "\t\t\t" + "£" + worker.getWage());
	}
}

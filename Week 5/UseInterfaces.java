public class UseInterfaces 
{

	public static void main(String[] args) 
	{
		GolferManager golfer = new GolferManager("Golfer 1", 
				"Golfer Department", 584, 28215f, "Club Name", 40);
		
		System.out.print("\nName" + "\t\t\t\t" + "Department" + "\t\t\t\t" + "Salary" 
						+ "\t\t\t\t" + "Golf Club" + "\t\t\t\t" + "Handicap");
		
		System.out.println("\n-----" + "\t\t\t\t" + "-----" + "\t\t\t\t\t" + "-----"  
								+ "\t\t\t\t"+ "-----" + "\t\t\t\t\t" + "-----");
		
		System.out.println(golfer.getName() + "\t\t\t" + golfer.getDept() + "\t\t\t" + "£" 
							+ golfer.getSalary() + "\t\t\t" + golfer.getClubName() 
							+ "\t\t\t\t" + golfer.getHandicap());
	}
}

class GolferManager implements Personnel2, Golfer
{
	protected float salary;
	protected String name, dept, clubName;
	protected int payrollNum, handicap;
	
	public GolferManager(String empName, String department, 
			int payrollNo, float salary, String clubName, int handicap)
	{
		this.name = empName;
		this.dept = department;
		this.payrollNum = payrollNo;
		this.salary = salary;
		this.clubName = clubName;
		this.handicap = handicap;
	}
	
	public float getSalary()
	{
		return salary;
	}
	
	public void setSalary(float newSalary)
	{
		salary = newSalary;
	}
	
	public void setDept(String newDept)
	{
		dept = newDept;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String newName)
	{
		name = newName;
	}
	
	public int getPayrollNum()
	{
		return payrollNum;
	}
	
	public String getDept()
	{
		 return dept;
	}
	
	public int getHandicap()
	{
		return handicap;
	}
	
	public String getClubName()
	{
		return clubName;
	}
}
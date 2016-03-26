class Manager extends Personnel
{
	private float salary;
	
	public Manager(String empName, String department, int payrollNo, float salary)
	{
		super(empName, department, payrollNo);
		this.salary = salary;
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
		super.dept = newDept;
	}
}
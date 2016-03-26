class Manager extends Personnel
{
	private float salary;
	
	public Manager(String empName, String department, int payrollNo, float salary)
	{
		super(empName, department, payrollNo);
		this.salary = salary;
	}
	
	public void setSalary(float newSalary)
	{
		salary = newSalary;
	}
	
	public void setDept(String newDept)
	{
		super.dept = newDept;
	}
	
	public float getAnnualIncome()
	{
		return salary;
	}
}
class Manager2 implements Personnel2
{
	private float salary;
	protected String name, dept;
	protected int payrollNum;
	
	public Manager2(String empName, String department, int payrollNo, float salary)
	{
		this.name = empName;
		this.dept = department;
		this.payrollNum = payrollNo;
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
}
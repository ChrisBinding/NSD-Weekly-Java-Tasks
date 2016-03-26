public class Personnel 
{
	private String name, dept;
	private int payrollNum;
	
	public Personnel(String empName, String department, int payrollNo)	// Constructor
	{
		name = empName;
		dept = department;
		payrollNum = payrollNo;
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

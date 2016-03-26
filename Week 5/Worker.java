class Worker extends Personnel
{
	private float hoursPerWeek;
	private float hourlyRate;
	
	public Worker(String empName, String department, 
			int payrollNo, float hoursPerWeek, float hourlyRate)
	{
		super(empName, department, payrollNo);
		this.hoursPerWeek = hoursPerWeek;
		this.hourlyRate = hourlyRate;
	}
	
	public void setHours(float newHoursPerPeek)
	{
		hoursPerWeek = newHoursPerPeek;
	}
	
	public void setRate(float newHourlyRate)
	{
		hourlyRate = newHourlyRate;
	}
	
	public float getWage()
	{
		return (hoursPerWeek * hourlyRate);
	}
	
	public float getAnnualIncome()
	{
		return (hoursPerWeek * hourlyRate * 52);
	}
}
package personnelPackage;

public class Personnel
{
	private long payrollNum;
	private String surname;
	private String firstNames;

	public Personnel(long payrollNum,
				String surname, String firstNames)
	{
		this.payrollNum = payrollNum;
		this.surname = surname;
		this.firstNames = firstNames;
	}

	public long getPayNum()
	{
		return payrollNum;
	}

	public String getSurname()
	{
		return surname;
	}

	public String getFirstNames()
	{
		return firstNames;
	}

	public void setSurname(String newName)
	{
		surname = newName;
	}
}
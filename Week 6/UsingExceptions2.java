public class UsingExceptions2
{
	public static void main(String[] args)
	{
		try
		{
			method1();			//Line 7.
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void method1() throws Exception
	{
		method2();				//Line 17.
	}
	
	public static void method2() throws Exception
	{
		method3();				//Line 22
	}

	public static void method3() throws Exception
	{
		throw new Exception("Exception in method3");		//Line 27
	}
}
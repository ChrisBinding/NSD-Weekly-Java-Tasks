
class CorruptionException extends Exception
{
	public CorruptionException() 
	{
		super("Data Corruption Detected - 3 Digit Rainfall Value Entered");
	}
	
	public CorruptionException(String message) 
	{
		super(message);
	}
}

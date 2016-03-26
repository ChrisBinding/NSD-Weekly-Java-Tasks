import java.io.*;

public class Task3
{
	public static void main(String[] args) throws FileNotFoundException   
	{
		String name1 = "Bob1";
		String name2 = "Chris1";

		PrintWriter fileOut = new PrintWriter("src\\Task3_Output.txt");

		fileOut.println(name1);
		fileOut.println(name2);

		fileOut.close();
	}
}

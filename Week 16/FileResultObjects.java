import java.io.*;
import java.util.*;

public class FileResultObjects
{
	public static void main(String[] args)
			throws IOException,ClassNotFoundException
	{
		String surname;
		int mark;
		Result resultRec;
		Scanner keyboard = new Scanner(System.in);
		ObjectOutputStream outFile;
		ObjectInputStream inFile;

		outFile = new ObjectOutputStream (
					new FileOutputStream("ResultObjects.dat"));
		
		for (int i=0; i<4; i++)
		{
			System.out.print("Enter surname: ");
			surname = keyboard.next();
			System.out.print("Enter mark: ");
			mark = keyboard.nextInt();
			resultRec = new Result(surname, mark);
			outFile.writeObject(resultRec);
		}
		outFile.close();
		keyboard.close();
		
		inFile = new ObjectInputStream(new FileInputStream("ResultObjects.dat"));

		Result resultObj;
		try
		{
			do
			{
				resultObj = (Result)inFile.readObject();

				System.out.println("\nSurname: " + resultObj.getName());
				System.out.println("Mark: " + resultObj.getMark());

			}while (true);
		}
		catch (EOFException eofEx)
		{
			System.out.println("\n\n*** End of file ***\n");
			inFile.close();
		}
	}
}

/**************************************************************

INSERT CODE FOR THE FOLLOWING:

(i) 	ACCEPTING EACH SURNAME & MARK FROM THE STANDARD INPUT
		STREAM (VIA OBJECT 'keyboard' ABOVE);
(ii)	CREATING AN OBJECT OF CLASS Result FOR EACH NAME
		AND MARK ENTERED (USING REFERENCE resultRec ABOVE)
		AND WRITING THAT OBJECT TO STREAM outFile.

INSERT FURTHER CODE FOR THE FOLLOWING:

(iii)	READING THE OBJECTS BACK FROM THE FILE, USING THE
		METHODS OF CLASS Result TO RETRIEVE AND DISPLAY EACH
		NAME AND MARK AS THEY ARE READ IN.

**************************************************************/


import java.io.*;
import java.util.*;

public class Task3
{
   private static final long REC_SIZE = 34;
   private static final int SURNAME_SIZE = 15;
   private static String surname;
   private static int mark;
   private static long recordNum;

   public static void main(String[] args)throws IOException
   {
	   Scanner input = new Scanner(System.in);
	   
	   RandomAccessFile results = new RandomAccessFile("results.dat", "rw");
	   
	   long numRecords = results.length()/REC_SIZE;
	   
	   System.out.print("\nEnter record number: ");
	   recordNum = input.nextLong();
	   
	   do 
		{
		   while ((recordNum<0) || (recordNum>numRecords))
		   {
			   System.out.println("\n*** Invalid number! ***\n");
			   System.out.print("\nEnter record number: ");
			   recordNum = input.nextLong();
			   
			   if (recordNum == 0)
			   {
				   System.out.println("\n*** PROGRAM TERMINATED  ***\n");
				   System.exit(1);
			   }
		   }
		     showRecord(results);	//Defined below.
		     
		     System.out.print("\nEnter record number: ");
			 recordNum = input.nextLong();

		     input.nextLine();	 //Get rid of carriage return!
		     
		}while (!(recordNum == 0));
	   	input.close();
	   	System.out.println("\n*** PROGRAM TERMINATED  ***\n");
   }

   public static void showRecord(RandomAccessFile file)throws IOException
   {
	   file.seek((recordNum-1)*REC_SIZE);
	   
	   surname = readString(file, SURNAME_SIZE);
	   mark = file.readInt();
	   System.out.println("Surname:  " + surname);
	   System.out.printf("Balance:  " + mark + "\n");
   }

   public static String readString(RandomAccessFile file, int fixedSize)throws IOException
   {
      String value = "";
      for (int i=0; i<fixedSize; i++)
         value+=file.readChar();
      return value;
   }
}
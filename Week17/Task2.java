import java.io.*;
import java.util.*;

public class Task2
{
   private static final long REC_SIZE = 34;
   private static final int SURNAME_SIZE = 15;
   private static String surname;
   private static int mark;

   public static void main(String[] args)throws IOException
   {
	   RandomAccessFile results = new RandomAccessFile("results.dat", "rw");
	   
	   Scanner input = new Scanner(System.in);

	   while (input.hasNext())
	   	{
	   	    surname = input.nextLine();
	   	    mark = input.nextInt();

	   	    input.nextLine();  
	        writeRecord(results); //Method defined below.
	   	}
	   	input.close();
	   
		System.out.println();
		showRecords(results);
	}

   public static void writeRecord(RandomAccessFile file) throws IOException
	{
		writeString(file, surname, SURNAME_SIZE);
		file.writeInt(mark);
	}
   
   public static void writeString(RandomAccessFile file, String text,int fixedSize) throws IOException
   {
      int size = text.length();

      if (size<=fixedSize)
      {
         file.writeChars(text);
         for (int i=size; i<fixedSize; i++)
            file.writeChar(' ');
      }
      else
         file.writeChars(text.substring(0,fixedSize));
   }
   
   public static void showRecords(RandomAccessFile file)throws IOException
   {
	long numRecords = file.length()/REC_SIZE;

	file.seek(0);		//Go to start of file.
	for (int i=0; i<numRecords; i++)
	{
		surname = readString(file, SURNAME_SIZE);
		mark = file.readInt();

		System.out.printf("" + surname + "   " + mark + "\n");
	}
   }

   public static String readString(RandomAccessFile file, int fixedSize)throws IOException
   {
      String value = "";
      for (int i=0; i<fixedSize; i++)
         value+=file.readChar();
      return value;
   }
}
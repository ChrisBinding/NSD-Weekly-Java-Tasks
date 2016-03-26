import java.util.Scanner;

public class LastLetter_Week1_4 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String word;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a word: ");
		
		word = keyboard.next();
		keyboard.close();
		
		int length = word.length();
		
		System.out.print(word.charAt(length - 1)); 
		
	}

}

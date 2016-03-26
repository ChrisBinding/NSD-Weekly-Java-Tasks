import java.util.*;

public class TeamArrays_Week2_Task6 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		final int TEAM_SIZE=5;
		String[] teamA = new String[TEAM_SIZE];
		String[] teamB = new String[TEAM_SIZE];

		Scanner keyboard = new Scanner(System.in);
		
		for (int i=0; i<TEAM_SIZE; i++)
		{
			System.out.print ("\nEnter team A surname " + (i+1 ) + ": ");
			teamA[i] = keyboard.nextLine();
		}
		
		for (int i=0; i<TEAM_SIZE; i++)
		{
			System.out.print ("\nEnter team B surname " + (i+1 ) + ": ");
			teamB[i] = keyboard.nextLine();
		}
		
		keyboard.close();
		
		System.out.print("\nTeam A" + "\t\t\t\t" + "Team B");
		System.out.print("\n-----" + "\t\t\t\t" + "-----");
		
		for (int i=0; i<TEAM_SIZE; i++)
		{
			System.out.print ("\n" + teamA[i] + "\t\t\t\t" + teamB[i]);
		}
	}

}

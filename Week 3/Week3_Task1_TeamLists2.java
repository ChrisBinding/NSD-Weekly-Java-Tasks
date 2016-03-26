import java.util.*;

public class Week3_Task1_TeamLists2
{
	//*** Now global declarations required! ***
	private static final int TEAM_SIZE = 5;
	private static String[] teamA = new String[TEAM_SIZE];
	private static String[] teamB = new String[TEAM_SIZE];
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.print("\n\nNames for Team A...\n");
		acceptNames(teamA);

		System.out.print("\n\nNames for Team B...\n");
		acceptNames(teamB);
		keyboard.close();

		showTeamLists();
	}

	public static void acceptNames(String[] team)
	{
		for (int i=0; i<TEAM_SIZE; i++)
		{
			System.out.print ("\nEnter surname " + (i+1 ) + ": ");
			team[i] = keyboard.nextLine();
		}
	}

	public static void showTeamLists()
	{
		System.out.print("\nTeam A" + "\t\t\t\t" + "Team B");
		System.out.print("\n-----" + "\t\t\t\t" + "-----");
		
		for (int i=0; i<TEAM_SIZE; i++)
		{
			System.out.print ("\n" + teamA[i] + "\t\t\t\t" + teamB[i]);
		}
	}
}
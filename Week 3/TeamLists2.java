import java.util.*;

public class TeamLists2
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


/***************************************************

	SUPPLY DEFINITION FOR METHOD acceptNames HERE!

***************************************************/


/***************************************************

	SUPPLY DEFINITION FOR METHOD showTeamLists HERE!

***************************************************/
}

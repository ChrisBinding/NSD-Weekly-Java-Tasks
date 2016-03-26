import java.sql.*;
import java.util.Scanner;

public class Task2
{
	static Connection link = null;
	static Statement statement = null;
	static ResultSet results = null;
	static String accNo;
	static String newSurname;
	static String newBalance;
	
    public static void main(String[] args)
    {
        try
        {
            link = DriverManager.getConnection(
                "jdbc:mysql://homepages.shu.ac.uk:3306/b3018108_db3",
                									"b3018108","chris123");
            	//"jdbc:mysql://localhost:3306/java",
            	//									"root","");
        }
        catch(SQLException e)
        {
            System.out.println("* Cannot connect to database! *");
            System.out.println("SQLException: " + e.getMessage());
            System.exit(1);
        }

        displayResults();
        
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nAccount Number to be deleted: \n");
        accNo = keyboard.nextLine();
        deleteRecord();
        displayResults();
        
        System.out.print("\nAccount Number to be changed: \n");
        accNo = keyboard.nextLine();
        System.out.print("\nNew Surname: \n");
        newSurname = keyboard.nextLine();
        System.out.print("\nNew Account Balance: \n");
        newBalance = keyboard.nextLine();
        updateRecord();
        
        keyboard.close();
        
              
        displayResults();
        closeConnection();  
    } // end main
    
    public static void updateRecord()
    {  
    	try
        {
    		statement = link.createStatement();
    		statement.executeUpdate("UPDATE accounts"
    							+ " SET Surname = '" + newSurname +"',"
    							+ "Balance='" + newBalance + "'"
    							+ " WHERE AccountNumber = " + accNo);

    		
        }
        catch(SQLException e)
        {
            System.out.println("* Cannot execute query! *");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static void deleteRecord()
    {  
    	try
        {
    		statement = link.createStatement();
    		statement.executeUpdate("DELETE FROM accounts"
    							+ " WHERE AccountNumber = " + accNo);

    		
        }
        catch(SQLException e)
        {
            System.out.println("* Cannot execute query! *");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static void displayResults()
    {
        try
        {
            statement = link.createStatement();
            results = statement.executeQuery("SELECT * FROM accounts");
        }
        catch(SQLException e)
        {
            System.out.println("* Cannot execute query! *");
            e.printStackTrace();
            System.exit(1);
        }
        
    	try
    	{
    		while (results.next())
    		{
    			System.out.println();
    			System.out.println("Account no. " + results.getInt(1));
    			System.out.println("Account holder:  " + results.getString(3)
                                + " " + results.getString(2));
    			System.out.printf("Balance: £%.2f %n%n",results.getFloat(4));
    		}
    	}
    	catch(SQLException e)
    	{
    		System.out.println("* Error retrieving data! *");
    		e.printStackTrace();
    		System.exit(1);
    	}
    }
    
    public static void closeConnection()
    {
    	try
        {
            link.close();
        }
        catch(SQLException e)
        {
            System.out.println("* Unable to disconnect! *");
            e.printStackTrace();
        }
    }
}

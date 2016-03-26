import java.sql.*;

public class JDBCMySQL
{
    public static void main(String[] args)
    {
        Connection link = null;
        Statement statement = null;
        ResultSet results = null;

        try
        {
            link = DriverManager.getConnection(
            		"jdbc:mysql://homepages.shu.ac.uk:3306/b3018108_db3","b3018108","chris123");
 //               "jdbc:mysql://homepages.shu.ac.uk:3306/b3018108_db1",
 //               									"b3018108","chris123");
        }
        catch(SQLException e)
        {
            System.out.println("* Cannot connect to database! *");
            System.out.println("SQLException: " + e.getMessage());
            System.exit(1);
        }

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

        finally
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
}

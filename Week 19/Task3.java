import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task3
{
    public static void main(String[] args)
    {
        Connection link = null;
        Statement statement = null;
        ResultSet results = null;

        try
        {
            link = DriverManager.getConnection(
                "jdbc:mysql://homepages.shu.ac.uk:3306/b3018108_db2",
                									"b3018108","chris123");
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
            results = statement.executeQuery("SELECT * FROM marks");
        }
        catch(SQLException e)
        {
            System.out.println("* Cannot execute query! *");
            e.printStackTrace();
            System.exit(1);
        }

        try
        {
            System.out.println("Student ID \t\t\t Student Mark");
            System.out.println("----------- \t\t\t ------------");
            
            while (results.next())
            {
                System.out.print(results.getInt(1));
                System.out.println("\t\t\t\t\t" + results.getInt(2));
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

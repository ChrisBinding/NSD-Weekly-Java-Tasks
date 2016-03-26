import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Task4 extends JFrame
{
	private static Connection connection;

	public static void main(String[] args)
	{
		Task4 frame = new Task4();

		frame.setTitle("Marks Data");
		frame.setSize(150,200);
		frame.setVisible(true);

		frame.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					if (connection != null)
					{
						try
						{
							connection.close();
							System.exit(0);
						}
						catch(SQLException sqlEx)
						{
							System.out.println(
								"* Error on closing connection! *");
							System.exit(1);
						}
					}
				}
			}
		);
	}

	public Task4()
	{
		Statement statement;
		ResultSet results;
		JTable table;
		JScrollPane scroller;
		final String[] HEADING =
			{"Student ID","Mark"};
		Vector<String> heads;
		Vector<Object> row, rows;
		//Alternatively, 'rows' could be declared
		//as type Vector<Vector<Object>>.

		try
		{
			connection = DriverManager.getConnection(
				"jdbc:mysql://homepages.shu.ac.uk:3306/b3018108_db2",
                									"b3018108","chris123");
				//"jdbc:mysql://localhost:3306/java",
				//									"root","");
			statement = connection.createStatement();
			results = statement.executeQuery(
									"SELECT * FROM marks");

			heads = new Vector<String>();
			for (int i=0; i<HEADING.length; i++)
			{
				heads.add(HEADING[i]);
			}

			rows = new Vector<Object>();

			while (results.next())
			{
				row = new Vector<Object>();
				row.add(results.getInt(1));
				row.add(results.getInt(2));
				rows.add(row);
			}
			table = new JTable(rows,heads);
			scroller = new JScrollPane(table);
			add(scroller, BorderLayout.CENTER);
		}
		catch(SQLException sqlEx)
		{
			System.out.println("* SQL error! *");
			System.exit(1);
		}
	}
}

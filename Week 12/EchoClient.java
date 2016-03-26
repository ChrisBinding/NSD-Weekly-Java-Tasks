//*** Supplied code ***

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class EchoClient extends JFrame
						implements ActionListener
{
	private JTextField hostInput,lineToSend;
	private JTextArea received;
	private JButton closeConnection;
	private static Socket socket;
	private	Scanner input;
	private	PrintWriter output;

   	public static void main(String[] args)
	{
        EchoClient frame = new EchoClient();

		frame.setSize(600,400);
        frame.setVisible(true);

        frame.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					if (socket != null)
					{
						try
						{
							socket.close();
						}
						catch (IOException ioEx)
						{
							System.out.println(
								"\n*** Unable to close link!***\n");
							System.exit(1);
						}
					}
					System.exit(0);
				}
			}
		);
    }

    public EchoClient()
	{
		JPanel hostPanel,entryPanel;
		JLabel hostPrompt,messagePrompt;

		hostPanel = new JPanel();

		hostPrompt = new JLabel("Enter host name:");
		hostInput = new JTextField(20);
		hostInput.addActionListener(this);
		hostPanel.add(hostPrompt);
		hostPanel.add(hostInput);
        add(hostPanel, BorderLayout.NORTH);

		entryPanel = new JPanel();

		messagePrompt = new JLabel("Enter text:");
        lineToSend = new JTextField(15);
		lineToSend.setEditable(false); 	//Change field to editable
										//when host name entered.
		lineToSend.addActionListener(this);

		/************************************************
		* ADD COMPONENTS TO PANEL AND APPLICATION FRAME *
		************************************************/
		entryPanel.add(messagePrompt);
		entryPanel.add(lineToSend);
		
		add(entryPanel, BorderLayout.WEST);
		
		/********************************************
		* NOW SET UP TEXT AREA AND THE CLOSE BUTTON *
		********************************************/
		received = new JTextArea(5,5);
		received.setWrapStyleWord(true);
		received.setLineWrap (true);
		received.setEditable(false);
		add(new JScrollPane(received), BorderLayout.CENTER);
		
		closeConnection = new JButton();
		closeConnection = new JButton("Close Connection");
		closeConnection.addActionListener(this);
		
		add(received);
		add(closeConnection, BorderLayout.SOUTH);
	 }

    public void actionPerformed(ActionEvent event)
	{
		final int ECHO = 7;
		String text,response,host;

		if (event.getSource() == closeConnection)
		{
			if (socket != null)
			{
				try
				{
					output.println("***CLOSE***");
					response = input.nextLine();
					received.append("\n" + response + "\n\n");
					socket.close();
					hostInput.setText("");
					hostInput.grabFocus();	//Note new method!
				}
				catch(IOException ioEx)
				{
					System.out.println(
						"\n*** Unable to close link!***\n");
					System.exit(1);
				}
				lineToSend.setEditable(false);
				hostInput.grabFocus();	//Note new method!
			}
			return;
		}

		if (event.getSource() == lineToSend)
		{

			/****************************************************
			* RETRIEVE LINE ENTERED BY USER AND SEND TO SERVER. *
			* RECEIVE AND DISPLAY SERVER'S RESPONSE.            *
			* (ALSO SUBSIDIARY ACTIONS.)
			****************************************************/
			
			//host = hostInput.getText();
			text = lineToSend.getText();
			
			output.println(text);
			
			response = input.nextLine();
        	
        	received.append("\nSERVER: " + response);
        	
        	lineToSend.setText("");
        	
			return;
		}
		

		//Must have been entry into host field...

		host = hostInput.getText();

		
        try
		{			
        	/*****************************
			* SET UP SOCKET & STREAMS.   *
			* (ALSO SUBSIDIARY ACTIONS.) *
			*****************************/
        	
        	socket = new Socket(host, 7);
        	
        	lineToSend.setEditable(true);
        	lineToSend.grabFocus();
        	
        	input = new Scanner(socket.getInputStream());
        	output = new PrintWriter(socket.getOutputStream(),true);
        	
        	
        	
		}
        catch (UnknownHostException uhEx)
       	{
			received.append("\n*** No such host! ***\n");
			hostInput.setText("");
		}
        catch (IOException ioEx)
     	{
			received.append("\n*** " + ioEx.toString() + " ***\n");
		}
   	}
}
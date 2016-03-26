import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class SimpleSound extends JFrame
							implements ActionListener
{
	private AudioClip clip;
	private JButton play, stop, loop;

	public static void main(String[] args)
	{
		SimpleSound frame = new SimpleSound();

		frame.setTitle("Simple Sound Demo");
		frame.setSize(300,200);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public SimpleSound()
	{
		JPanel buttonPanel;

		try
		{
            clip = Applet.newAudioClip(new URL("file:cuckoo.au"));
		}
		catch(MalformedURLException muEx)
		{
			System.out.println("*** Invalid URL! ***");
			System.exit(1);
		}

		play = new JButton("Play");
		play.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		loop = new JButton("Loop");
		loop.addActionListener(this);

		buttonPanel = new JPanel();
		buttonPanel.add(play);
		buttonPanel.add(stop);
		buttonPanel.add(loop);

		add(buttonPanel,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == play)
		{
			String inputValue = JOptionPane.showInputDialog("Please input the number of plays: ");
			int inputInt = Integer.parseInt(inputValue);
			
			for (int x=0; x < inputInt; x++)
			{
				clip.play();
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource() == stop)
			clip.stop();
		if (e.getSource() == loop)
			clip.loop();
	}
}


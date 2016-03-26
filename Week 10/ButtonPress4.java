import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPress4 extends JFrame implements ActionListener
{
	private JTextArea messageBox;
	private boolean enlargedFont;
	
	
	public static void main(String[] args)
	{
		ButtonPress4 frame = new ButtonPress4();

		frame.setTitle("Task 2");
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ButtonPress4()
	{
		JButton button1;
		
		setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Enter text: ");
		
		messageBox = new JTextArea(5,20);
		messageBox.setWrapStyleWord(true);
		messageBox.setLineWrap(true);
		
		button1 = new JButton("Enlarge/reduce font");
		
		add(label);
		add(new JScrollPane(messageBox));
		add(button1);
		
		button1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (enlargedFont)	//Global Boolean variable
		{					//initially set to 'false'.
			messageBox.setFont(
					new Font("TimesRoman",Font.PLAIN,12));
			enlargedFont = false;
		}
		else
		{
			messageBox.setFont(
					new Font("TimesRoman",Font.PLAIN,18));
			enlargedFont = true;
		}
	}
}
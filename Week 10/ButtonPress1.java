import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPress1 extends JFrame
{
	public static void main (String[] args)	 									
	{
		ButtonPress1 frame = new ButtonPress1();
		frame.setTitle("Task 1");					
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public ButtonPress1()
	{
		JButton button1;	
		ButtonHandler handler;
 
		setLayout(new BorderLayout());
		button1 = new JButton("Press me");
		add(button1, BorderLayout.SOUTH);
		
		handler = new  ButtonHandler();
		button1.addActionListener(handler);
	}
	
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(
					null, "Remember to close main window");
		}
	}
}

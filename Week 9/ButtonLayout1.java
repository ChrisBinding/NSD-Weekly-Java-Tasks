import java.awt.*;
import javax.swing.*;

public class ButtonLayout1 extends JFrame
{
	public static void main (String[] args)
	{
		ButtonLayout1 frame = new ButtonLayout1();

		frame.setTitle("ButtonLayout1");
		frame.setSize(500,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ButtonLayout1()
	{
		JButton button1, button2, button3, button4;

		setLayout(new BorderLayout());
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton ("Button 4");

		add(button1,BorderLayout.NORTH);
		add(button2,BorderLayout.SOUTH);
		add(button3,BorderLayout.EAST);
		add(button4,BorderLayout.WEST);
	}
}
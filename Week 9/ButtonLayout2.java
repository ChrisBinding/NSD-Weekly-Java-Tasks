import java.awt.*;
import javax.swing.*;

public class ButtonLayout2 extends JFrame
{
	public static void main (String[] args)
	{
		ButtonLayout2 frame = new ButtonLayout2();

		frame.setTitle("ButtonLayout2");
		frame.setSize(400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ButtonLayout2()
	{
		JButton button1, button2, button3, button4, button5, button6;
		
		setLayout(new FlowLayout());
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton ("Button 4");
		button5 = new JButton("Button 5");
		button6 = new JButton ("Button 6");

		add(button1);	
		add(button2);	
		add(button3);	
		add(button4);	
		add(button5);
		add(button6);	

	}
}
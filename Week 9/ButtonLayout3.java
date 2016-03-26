import java.awt.*;
import javax.swing.*;

public class ButtonLayout3 extends JFrame
{
	public static void main (String[] args)
	{
		ButtonLayout3 frame = new ButtonLayout3();

		frame.setTitle("ButtonLayout3");
		frame.setSize(300,110);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ButtonLayout3()
	{
		JButton button1, button2, button3, button4, button5, button6;
		
		setLayout(new GridLayout(2,3));
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPress2 extends JFrame implements ActionListener
{
	private JTextField text1;
	
	public static void main(String[] args)
	{
		ButtonPress2 frame = new ButtonPress2();

		frame.setTitle("Task 2");
		frame.setSize(500,300);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ButtonPress2()
	{
		JButton button1, button2;
		

		setLayout(new FlowLayout());
		button1 = new JButton("Hello");
		button2 = new JButton("Goodbye");
		text1 = new JTextField(10);
		
		add(button1);
		add(text1);
		add(button2);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		text1.setText(e.getActionCommand());
	}
}
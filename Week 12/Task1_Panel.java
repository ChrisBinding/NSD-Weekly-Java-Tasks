import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task1_Panel extends JFrame implements ItemListener, ActionListener
{
	private JTextField textField;
	private final Font PLAIN_FONT = new Font("SansSerif",Font.PLAIN,14);
	private JRadioButton red,green,blue;

	public static void main(String[] args)
	{
		Task1_Panel frame = new Task1_Panel();

		frame.setTitle("Radio Button Colour Panel Demo");
		frame.setSize(300, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public Task1_Panel()
	{
		ButtonGroup fontGroup;
		JPanel buttonPanel = new JPanel();
		JButton button = new JButton();

		setLayout(new FlowLayout());

		button = new JButton("Quit");
		
		red = new JRadioButton("Red");
		green = new JRadioButton("Green");
		blue	= new JRadioButton("Blue");

		textField = new JTextField("Here is some great inital text!",25);
		textField.setFont(PLAIN_FONT);
		add(textField);

		red.addItemListener(this);
		green.addItemListener(this);
		blue.addItemListener(this);
		button.addActionListener(this);

		fontGroup = new ButtonGroup();
		fontGroup.add(red);
		fontGroup.add(green);
		fontGroup.add(blue);
		
		buttonPanel.add(red);
		buttonPanel.add(green);
		buttonPanel.add(blue);
		buttonPanel.add(button);
		
		add(buttonPanel,BorderLayout.SOUTH);
	}

	public void itemStateChanged(ItemEvent e)
	{
		if (e.getSource()==red)
			textField.setForeground(Color.RED);
		else if (e.getSource()==green)
			textField.setForeground(Color.GREEN);
		else
			textField.setForeground(Color.BLUE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	   System.exit(0);
	}
}
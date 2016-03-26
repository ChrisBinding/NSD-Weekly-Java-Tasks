import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioExample extends JFrame implements ItemListener
{
	private JTextField textField;
	private final Font PLAIN_FONT = new Font("SansSerif",Font.PLAIN,14);
	private JRadioButton red,green,blue;

	public static void main(String[] args)
	{
		RadioExample frame = new RadioExample();

		frame.setTitle("Radio Button Colour Demo");
		frame.setSize(300, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public RadioExample()
	{
		ButtonGroup fontGroup;

		setLayout(new FlowLayout());

		red = new JRadioButton("Red");
		green = new JRadioButton("Green");
		blue	= new JRadioButton("Blue");

		textField = new JTextField("Here is some great inital text!",25);
		textField.setFont(PLAIN_FONT);
		add(textField);

		add(red);
		add(green);
		add(blue);

		red.addItemListener(this);
		green.addItemListener(this);
		blue.addItemListener(this);

		fontGroup = new ButtonGroup();
		fontGroup.add(red);
		fontGroup.add(green);
		fontGroup.add(blue);
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
}
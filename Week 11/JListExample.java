import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JListExample extends JFrame implements ListSelectionListener
{
	private JTextField textField;
	private final Font PLAIN_FONT = new Font("  ",Font.PLAIN,14);
	private JList list;

	public static void main(String[] args)
	{
		JListExample frame = new JListExample();

		frame.setTitle("Radio Button Colour Demo");
		frame.setSize(300, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JListExample()
	{
		final String[] COLOUR_NAME ={"Red", "Green", "Blue"};

		setLayout(new FlowLayout());
		
		textField = new JTextField("Here is some great inital text!",25);
		textField.setFont(PLAIN_FONT);
		add(textField);
		
		list = new JList(COLOUR_NAME);
		list.setVisibleRowCount(2);
		add(new JScrollPane(list));
		list.addListSelectionListener(this);
	}

	public void valueChanged(ListSelectionEvent event)
	{
		final Color[] COLOUR = {Color.RED, Color.GREEN, Color.BLUE};

		textField.setForeground(COLOUR[list.getSelectedIndex()]);
	}
}
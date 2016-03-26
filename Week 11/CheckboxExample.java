import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckboxExample extends JFrame implements ItemListener
{
	private JTextArea messageBox;
	private JCheckBox enlargeFont;
	
	
	public static void main(String[] args)
	{
		CheckboxExample frame = new CheckboxExample();

		frame.setTitle("Checkbox Example");
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public CheckboxExample()
	{
		setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Enter text: ");
		messageBox = new JTextArea(5,20);
		
		add(label);
		add(messageBox);
		
		enlargeFont = new JCheckBox("Enlarge font");
		add(enlargeFont);

		enlargeFont.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getSource() == enlargeFont)
		{
			//Now check direction of 'toggle'...
			if (e.getStateChange() == ItemEvent.SELECTED)
				messageBox.setFont(new Font("SansSerif",Font.PLAIN,18));	
			else
				messageBox.setFont(new Font("SansSerif",Font.PLAIN,12));
		}
	}

}
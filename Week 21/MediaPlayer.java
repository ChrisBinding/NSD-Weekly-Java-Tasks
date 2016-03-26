 import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.*;
import java.net.URI;

public class MediaPlayer extends JFrame
		implements ActionListener, ControllerListener
{
	private JTextField fileName;
	private File file;
	private Player player;

	public static void main(String args[])
   	{
      	MediaPlayer frame = new MediaPlayer();

		frame.setTitle( "Java Media Player Demo" );
		frame.setSize(600, 400);
      	frame.setVisible(true);

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public MediaPlayer ()
   {
		JPanel inputPanel = new JPanel();
      	JLabel prompt = new JLabel("Audio/video file name: ");
		fileName = new JTextField(25);

		inputPanel.add(prompt);
		inputPanel.add(fileName);
		add(inputPanel, BorderLayout.NORTH);

		fileName.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
   	{
		try
		{
			getFile();
 			createPlayer();
		}
		catch(FileNotFoundException fnfEx)
		{
			JOptionPane.showMessageDialog(this,
				"File not found!", "Invalid file name",
				JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception otherEx)
		{
         	JOptionPane.showMessageDialog(this,
            	"Unable to load file!", "Invalid file type",
           		 JOptionPane.ERROR_MESSAGE );
         	otherEx.printStackTrace();
     	}
	}

   	private void getFile() throws FileNotFoundException
   	{
		file = new File(fileName.getText());
		if (!file.exists())
			throw new FileNotFoundException();
	}

   	private void createPlayer() throws Exception
   	{
   		Container pane = getContentPane(); //Note!!!
   		
   		if (player != null)
   		{		
   			Component visualComponent =
           			player.getVisualComponent();
   			
   			if (visualComponent != null)
   				pane.remove(visualComponent);
   				
   			Component controlsComponent =
               	player.getControlPanelComponent();

         	if (controlsComponent != null)
         		pane.remove(controlsComponent);  			
   			
   			player.stop();
   		}
   		
		URI uri = file.toURI();

		player = Manager.createPlayer(uri.toURL());
		player.addControllerListener(this);
		player.start();
		//fileName.setEnabled(false);
	}

	public void controllerUpdate(ControllerEvent e)
	{
		Container pane = getContentPane(); //Note!!!

       	if (e instanceof RealizeCompleteEvent)
		{
			Component visualComponent =
               			player.getVisualComponent();

     		if (visualComponent != null)
				pane.add(visualComponent, BorderLayout.CENTER);

         	Component controlsComponent =
               	player.getControlPanelComponent();

         	if (controlsComponent != null)
				pane.add(controlsComponent, BorderLayout.SOUTH);

			pane.doLayout();
		}
	}
}



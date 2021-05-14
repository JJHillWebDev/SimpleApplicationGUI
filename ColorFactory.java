import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 	  This GUI allows a user to select a button that will change the color
 	  of the center panel and radio buttons that will change the color of the
 	  text in the center panel.
    
    @author Jeremy Hill
    @version 1.8.0_271
 */
public class ColorFactory extends JFrame
{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
  
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel messageLabel;
  
  	/**
  	 *	default constructor
  	 */
    public ColorFactory()
    {
    	  //set title, size and specify an action for the close button
        setTitle("Color Factory");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //set the layout manager to BorderLayout
        setLayout(new BorderLayout());

        //build the top and button panels and add to the pane
        buildTopPanel();
        add(topPanel, BorderLayout.NORTH);
        buildBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        //add message to Label and add the Label to the pane
        messageLabel = new JLabel("Top buttons change the panel color and "
                + "bottom radio buttons change the text color");
        messageLabel.setForeground(Color.BLUE);
        add(messageLabel, BorderLayout.CENTER);
    }
  	

  	/**
  	 *	The buildTopPanel method creates a panel that contains three 
  	 *	buttons, red, orange, and yellow that change the background color.
  	 */
    private void buildTopPanel()
    {
    	  //create JPanel with FlowLayout and a white background
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.WHITE);
      
      	//create three Buttons with ActionCommands and ActionListeners
        JButton redButton = new JButton("Red");
        redButton.setBackground(Color.RED);
        redButton.setActionCommand("R");
        redButton.addActionListener(new ButtonListener());
      
        JButton orangeButton = new JButton("Orange");
        orangeButton.setBackground(Color.ORANGE);
        orangeButton.setActionCommand("O");
        orangeButton.addActionListener(new ButtonListener());
      
        JButton yellowButton = new JButton("Yellow");
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setActionCommand("Y");
        yellowButton.addActionListener(new ButtonListener());
      
      	//add Buttons to the JPanel
        topPanel.add(redButton);
        topPanel.add(orangeButton);
        topPanel.add(yellowButton);
    }
  

  	/**
  	 *	The buildBottomPanel method creates a panel that contains three 
	   *	radio buttons with the colors green, blue, and cyan that change 
	   * 	the color of the messageLabel.
  	 */
    private void buildBottomPanel()
    {
    	  //create JPanel with FlowLayout and a white background
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(Color.WHITE);
      
      	//create three RadioButtons with ActionCommands and ActionListeners
        JRadioButton greenButton = new JRadioButton("Green");
        greenButton.setForeground(Color.GREEN);
        greenButton.setBackground(Color.WHITE);
        greenButton.setActionCommand("G");
        greenButton.addActionListener(new RadioButtonListener());
      
        JRadioButton blueButton = new JRadioButton("Blue", true);
        blueButton.setForeground(Color.BLUE);
        blueButton.setBackground(Color.WHITE);
        blueButton.setActionCommand("B");
        blueButton.addActionListener(new RadioButtonListener());
      
        JRadioButton cyanButton = new JRadioButton("Cyan");
        cyanButton.setForeground(Color.CYAN);
        cyanButton.setBackground(Color.WHITE);
        cyanButton.setActionCommand("C");
        cyanButton.addActionListener(new RadioButtonListener());
      
      	//create a ButtonGroup for the three RadioButtons
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(greenButton);
        radioButtonGroup.add(blueButton);
        radioButtonGroup.add(cyanButton);
      
      	//add RadioButtons to the JPanel
        bottomPanel.add(greenButton);
        bottomPanel.add(blueButton);
        bottomPanel.add(cyanButton);
    }


    /**
  	 	 This event handler will handle all button events.
  	 */
    private class ButtonListener implements ActionListener
    {
    	/**
  	 	 *	The actionPerformed method determines which color to set  
  	 	 *	the background of the content pane.
  		 *	@param e Holds the ActionEvents for the Buttons
  	 	 */
        public void actionPerformed(ActionEvent e)
        {
        	  //holds the ActionCommand
            String input = e.getActionCommand();
            Color color;

            //determine which color to set the background of the content pane
            if (input == "R")
            {
            	color = Color.RED;
            	getContentPane().setBackground(color);
            }
            else if (input == "O")
            {
            	color = Color.ORANGE;
            	getContentPane().setBackground(color);
            }
            else
            {
            	color = Color.YELLOW;
            	getContentPane().setBackground(color);
            }
        }
    }
  

  	/**
  		  This event handler will handle all radio button events.
  	 */
    private class RadioButtonListener implements ActionListener
    {
    	/**
  	 	 *	The actionPerformed method determines which color should 
  	 	 *	be used for the text of the message.
  		 *	@param e Holds the ActionEvents for the RadioButtons
  	 	 */
        public void actionPerformed(ActionEvent e)
        {
        	  //holds the ActionCommand
            String input = e.getActionCommand();
            Color color;

            //determine which color to set the forground of the messageLabel
            if (input == "G")
            {
            	color = Color.GREEN;
            	messageLabel.setForeground(color);
            }
            else if (input == "B")
            {
            	color = Color.BLUE;
            	messageLabel.setForeground(color);
            }
            else
            {
            	color= Color.CYAN;
            	messageLabel.setForeground(color);
            }
        }
    }

  	
  	/**
  	 *	The main method creates an instance of the ColorFactory
  	 *	class, causing it to display its window.
  	 *	@param args the command line arguments
  	 */
    public static void main(String args[])
    {
        new ColorFactory().setVisible(true);
    }
}
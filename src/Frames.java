/*
 * Kcirde Santos
 * Kexin Zheng
 * CS-170-02
 * Final Project
 * 
 * Frames class: 
 * stores all the required frames, except record frame, for the game
 * i.e. main page frame, in game frame, learning frame, result frame, and etc. 
 * contains class variables that are frame components
 */
import java.awt.*;
import java.io.File;
import java.net.URL;

import javax.swing.*;

public class Frames extends JFrame
{
	// panel
	Panels panel;
	// background image
    JLabel bg;
    // gb layout (title page only)
    GridBagConstraints gbc;

	//Constructor
	public Frames()
	{
		// set up panel
    	panel = new Panels(); 
    	panel.setThisFrame(this);
		TitlePage();
	}

	// title frame
	public void TitlePage()
	{
		try {	
			//frame title
			setTitle("Math for Fun");
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        	//set up background
			URL localUrl = ClassLoader.getSystemResource("images/background.jpg");
        	//backup ways to load images
        	if(localUrl==null)
        	{
        		localUrl = new URL("file:"+new File(".").getCanonicalPath() + "/" + "images/background.jpg");
        		bg = new JLabel(new ImageIcon(localUrl));
        	}
        	else
        		bg = new JLabel(new ImageIcon(localUrl));
     
        	//label.setLayout(new FlowLayout());
        	this.setContentPane(bg);
    		
        	// setup layout
        	setLayout(new GridBagLayout());
        
        	// get the main page panel
        	panel.mainPage(); 
        
        	// add panel
        	add(panel, gbc);
        	
            // other characteristics
            pack();
            setLocationRelativeTo(null);
        }
		// exception appeared
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Failed openning the game. \n" + e); 
			System.exit(0);
        }
	}
	
	// learning frame
	public void Learn()
	{
		try {      
			// absolute layout
			setLayout(null);
			// change panel
        	panel.learning(); 
        	// add panel
        	add(panel, gbc);
        	// refresh the page
            revalidate();
            repaint();
        }
		// exception appeared
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Failed openning the learning section. \n" + e); 
			System.exit(0);
        }
	}

	// gaming frame
	public void InGame()
	{
		try {      
			// absolute layout
			setLayout(null);
			// change panel
        	panel.playing();
        	// add panel
        	add(panel, gbc);
        	// refresh the page
            revalidate();
            repaint();
        }
		// exception appeared
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Failed openning the get-name section. \n" + e); 
			System.exit(0);
        }
	}
	
	// get name frame
	public void Name()
	{
		try {      
			// absolute layout
			setLayout(null);
			// change panel
        	panel.getUserName();
        	// add panel
        	add(panel, gbc);
        	// refresh the page
            revalidate();
            repaint();
        }
		// exception appeared
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Failed openning the get-name section. \n" + e); 
			System.exit(0);
        }
	}
	
	// get score/result frame
	public void Result()
	{
		try {      
			// absolute layout
			setLayout(null);
			// change panel
        	panel.getResult();
        	// add panel
        	add(panel, gbc);
        	// refresh the page
            revalidate();
            repaint();
        }
		// exception appeared
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Failed openning the get-name section. \n" + e); 
			System.exit(0);
        }
	}
	
}
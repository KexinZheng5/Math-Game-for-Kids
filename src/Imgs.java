/*
 * Kcirde Santos
 * Kexin Zheng
 * CS-170-02
 * Final Project
 * 
 * Imgs class: 
 * stores all the icon images used (no background)
 * includes apples, balloons, and other clip arts for display
 * contains static class variables to store images and related data
 */
import java.io.File;
import java.net.URL;
import java.util.Random;
import javax.swing.*;

public class Imgs
{
	// images with their names
	public static String names[] = {"apple", "balloon","bubble", "circle", "flag", "flower", "leaf", "orange", "square", "star", "correct", "incorrect"};
	public static ImageIcon images[] = new ImageIcon[12];
	// store random image index
	public static int randoms; 
	
	// initialize static variables
	static
	{
		try 
		{
			// initialize images
			if(ClassLoader.getSystemResource("images/"+ names[0] +".png")==null)
        	{
				for(int i = 0; i < images.length; i++)
				{
					images[i] = new ImageIcon(new URL("file:"+new File(".").getCanonicalPath() + "/" + "images/"+ names[i] +".png"));
        	
				}
        	}
			else
			{
				for(int i = 0; i < images.length; i++)
				{
					images[i] = new ImageIcon(ClassLoader.getSystemResource("images/"+ names[i] +".png"));
				}
			}
			
		}
		// exception thrown
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Failed loading images. \n" + e); 
			System.exit(0);
		}
	}
	
	//generate random images, return the image index
	public static void randomImage()
	{
		Random rand = new Random();
		randoms = rand.nextInt(10); // random number from 0 to 9
	}
}
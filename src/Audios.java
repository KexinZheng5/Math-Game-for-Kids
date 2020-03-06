/*
 * Kcirde Santos
 * Kexin Zheng
 * CS-170-02
 * Final Project
 * 
 * Audios class: 
 * stores all the audios used in this game
 * includes background music and sound effects when user finished answering a question, and etc.
 * contains static class variables to store audio clips
 */
import javax.swing.*;
import java.applet.*;
import java.io.File;
import java.net.URL;

public class Audios{
	// variables needed
	public static AudioClip bgm;
	public static AudioClip finished;
	public static AudioClip correct;
	public static AudioClip incorrect;
	
	// initialize static variables
	static 
	{
		try {
			// get bgm and sound effects
			if(ClassLoader.getSystemResource("sounds/bgm.au")==null)
			{
				bgm = Applet.newAudioClip(new URL("file:"+new File(".").getCanonicalPath() + "/" +"sounds/bgm.au"));	
				finished = Applet.newAudioClip(new URL("file:"+new File(".").getCanonicalPath() + "/" +"sounds/applause.wav"));
				correct = Applet.newAudioClip(new URL("file:"+new File(".").getCanonicalPath() + "/" +"sounds/correct.wav"));
				incorrect = Applet.newAudioClip(new URL("file:"+new File(".").getCanonicalPath() + "/" +"sounds/incorrect.wav"));
			}
			else
			{
				bgm = Applet.newAudioClip(ClassLoader.getSystemResource("sounds/bgm.au"));	
				finished = Applet.newAudioClip(ClassLoader.getSystemResource("sounds/applause.wav"));
				correct = Applet.newAudioClip(ClassLoader.getSystemResource("sounds/correct.wav"));
				incorrect = Applet.newAudioClip(ClassLoader.getSystemResource("sounds/incorrect.wav"));
			}
		}
		// manage exceptions
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed loading audios. \n" + e); 
			System.exit(0);
		}
	}
}
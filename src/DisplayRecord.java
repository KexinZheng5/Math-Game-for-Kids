/*
 * Kcirde Santos
 * Kexin Zheng
 * CS-170-02
 * Final Project
 * 
 * DisplayRecord class: 
 * Record frame and contents
 * along with other functions that operates on reading and writing record file
 */
import java.awt.*;
import java.io.*;
import java.net.URL;

import javax.swing.*;

public class DisplayRecord extends JFrame
{
	// display records
	public void Display()
    {
        setTitle("Top 5 Record");
        centerWindow(this);
        setSize(1000, 700);
        setPreferredSize(new Dimension(1000, 700));
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(56, 55, 114));
        
        // display content
        
        // title
     	JLabel title = new JLabel("Top 5 Record");
        title.setFont(new Font("Arial",Font.BOLD, 60));
        title.setForeground(new Color(225, 225, 225));
        title.setBounds(150,50,500,200);
        add(title);
        
        // name
		JLabel tn = new JLabel("Name");
        tn.setFont(new Font("Arial",Font.BOLD, 40));
        tn.setForeground(new Color(225, 225, 225));
        tn.setBounds(150,150,900,200);
        add(tn);
        
        // score
        JLabel ts = new JLabel("Score");
        ts.setFont(new Font("Arial",Font.BOLD, 40));
        ts.setForeground(new Color(225, 225, 225));
        ts.setBounds(550,150,500,200);
        add(ts);

        
        // players
        try
        {
        	String[] rec = getRecord();
        	for(int i = 0; i < 5; i++)
        	{
        		// name
        		int pos = rec[i].indexOf('@');
        		JLabel n = new JLabel(rec[i].substring(0, pos));
                n.setFont(new Font("Arial",Font.BOLD, 30));
                n.setForeground(new Color(225, 225, 225));
                n.setBounds(150,220 + i*50,500,200);
                add(n);
                
        		// score
                JLabel s = new JLabel(rec[i].substring(pos+1));
                s.setFont(new Font("Arial",Font.BOLD, 30));
                s.setForeground(new Color(225, 225, 225));
                s.setBounds(550,220 + i*50,500,200);
                add(s); 
        	}
        	add(new JLabel(" "));
        }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Failed getting records. \n" + e); 
			System.exit(0);
        }

        // display players
    }

	// center
    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-1000)/2, (d.height-700)/2);
    }
	
	// new record
	public void newRecord(String name, int score, int line) throws IOException 
	{
		//File file = new File("record.txt");
		String[] newContent;
		
		newContent = getRecord();
		
		File temp = new File("record.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		int count = 5;
		
		for(int i = 0; i < count; i++)
		{
			if(i == line)
			{
				writer.write(name + "@" + score);
				writer.newLine();
				line = -1;
				i--;
				count--;
			}
			else
			{
				writer.write(newContent[i]);
				writer.newLine();
			}
		}
		
		writer.close(); 
		//temp.renameTo(file);
	}
	
	
	// get the line that can be replaced by the new score
	public int compareRecord(int score) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("record.txt"));
		String line;
		for(int i = 0; i < 5; i++)
		{
			int numPosition;
			line = reader.readLine();
			numPosition = line.indexOf('@') + 1;
			if(score >= Integer.parseInt(line.substring(numPosition)))
			{
				reader.close();
				return i;
			}
		}
		reader.close();
		return -1;
	}
	
	
	// get the content in the file
	public String[] getRecord() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("record.txt"));
		String[] content = new String[5];
		for(int i = 0; i < content.length; i++)
		{
			content[i] = reader.readLine();
		}
		reader.close();
		
		return content;
	}
	
	// check if name exists in the record
	public boolean containName(String name) throws IOException
	{
		String[] contents = getRecord();
		
		for(int i = 0; i < 5; i ++)
		{
			int pos = contents[i].indexOf('@');
    		if(name.equals(contents[i].substring(0, pos)))
    		{
    			return true;
    		}
		}
		return false;
	}
}
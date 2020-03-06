/*
 * Kcirde Santos
 * Kexin Zheng
 * CS-170-02
 * Final Project
 * 
 * Panels class: 
 * stores all the jpanels for each frame
 * each function assembles the components to form the wanted page
 * i.e. main page panel, in game panel, learning panel, result panel, and etc. 
 * contains class variables that are panel components
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;

class Panels extends JPanel implements ActionListener {		//Button panel
	// current frame
	private Frames thisFrame; 
	
	// store player info
	private Games player;
	
	// components
	private JLabel title;
	private JLabel message;
	private JButton learn, 
					newGame,
					record, 
					submit, 
					back, 
					previous, 
					next, 
					start;
	private JTextField input;
 
	// page number (learning)
	private int pageNum;
	
	// gbc for starting page
	GridBagConstraints gbc;
	
	// constructor
	public Panels() 
	{	
		// setup and initialize all the buttons
        learn = new JButton("Let's Learn!");
        learn.addActionListener(this);
        newGame = new JButton("New Game");
        newGame.addActionListener(this);
        record = new JButton("Records");
        record.addActionListener(this);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        back = new JButton("Back to main page");
        back.addActionListener(this);
        previous = new JButton("< Previous"); 
        previous.addActionListener(this);
        next = new JButton("Next >"); 
        next.addActionListener(this);
        title = new JLabel(); 
        start = new JButton("Start the game!"); 
        start.addActionListener(this);
        gbc = new GridBagConstraints();
        message = new JLabel();
        player = new Games();
	}
	
	// main page panel
	public void mainPage()
	{
		// clear panel
		removeAll(); 
		
		// set layout
		setLayout(new GridBagLayout());
        
        // set grid bag constraints
        gbc.insets=  new Insets(0, 0, 50, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
           
        // display title and buttons
        title.setText("Math is Fun!");
        title.setFont(new Font("Arial",Font.BOLD, 80));
        title.setForeground(new Color(48, 48, 48));
        add(title, gbc);
        
        // learn button
        learn.setFont(new Font("Arial",Font.PLAIN, 60));
        learn.setForeground(new Color(255, 255, 255));
        learn.setBackground(new Color(112, 150, 75));
        learn.setFocusPainted(false);
        learn.setOpaque(true);
        learn.setPreferredSize(new Dimension(450, 80));
        add(learn, gbc);
        
        // new game button
        newGame.setFont(new Font("Arial",Font.PLAIN, 60));
        newGame.setForeground(new Color(255, 255, 255));
        newGame.setBackground(new Color(61, 99, 237));
        newGame.setFocusPainted(false);
        newGame.setOpaque(true);
        newGame.setPreferredSize(new Dimension(450, 80));
        add(newGame, gbc);
        
        // record button
        record.setFont(new Font("Arial",Font.PLAIN, 60));
        record.setForeground(new Color(255, 255, 255));
        record.setBackground(new Color(109, 75, 209));
        record.setFocusPainted(false);
        record.setOpaque(true);
        record.setPreferredSize(new Dimension(450, 80));
        add(record, gbc);
        
        setOpaque(false);
	}
	
	// learning page panel
	public void learning()
	{
		// clear
		removeAll(); 
		// absolute layout
		setLayout(null);
		// set bound
		setBounds(0,0,2000,1000);
		
		// back button
        back.setFont(new Font("Arial",Font.PLAIN, 20));
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(96, 96, 96));
        back.setFocusPainted(false);
        back.setOpaque(true);
        back.setBounds(25,25,200,50);
        add(back);
        
        // record button
        record.setFont(new Font("Arial",Font.PLAIN, 20));
        record.setForeground(new Color(255, 255, 255));
        record.setBackground(new Color(109, 75, 209));
        record.setFocusPainted(false);
        record.setOpaque(true);
        record.setBounds(270,25,130,50);
        add(record);
    
        // display text
        if(pageNum == 0) 	// one item
        	title.setText((pageNum + 1) +" "+ Imgs.names[pageNum] + ":");
        else				// more than one (add s)
        	title.setText((pageNum + 1) +" "+ Imgs.names[pageNum] + "s" + ":");
        title.setFont(new Font("Arial",Font.BOLD, 70));
        title.setForeground(new Color(48, 48, 48));
        title.setBounds(200,120,600,200);
        add(title);
        
        // display pictures
        displayPic(pageNum + 1, pageNum, 300);
        
        // previous button
        previous.setFont(new Font("Arial",Font.PLAIN, 30));
        previous.setForeground(new Color(255, 255, 255));
        previous.setBackground(new Color(112, 150, 75));
        previous.setFocusPainted(false);
        previous.setOpaque(true);
        previous.setPreferredSize(new Dimension(200, 50));
        previous.setBounds(150, 550, 200, 50);
        add(previous);
        
        
        // next button
        next.setFont(new Font("Arial",Font.PLAIN, 30));
        next.setForeground(new Color(255, 255, 255));
        next.setBackground(new Color(112, 150, 75));
        next.setFocusPainted(false);
        next.setOpaque(true);
        next.setPreferredSize(new Dimension(200, 50));
        next.setBounds(700, 550, 200, 50);
        add(next);

        setOpaque(false);
	}
	
	// get user name panel
	public void getUserName()
	{
		// clear
		removeAll(); 
		// absolute layout
		setLayout(null);
		// set bound
		setBounds(0,0,2000,1000);
		
		// back button
        back.setFont(new Font("Arial",Font.PLAIN, 20));
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(96, 96, 96));
        back.setFocusPainted(false);
        back.setOpaque(true);
        back.setBounds(25,25,200,50);
        add(back);
        
        // record button
        record.setFont(new Font("Arial",Font.PLAIN, 20));
        record.setForeground(new Color(255, 255, 255));
        record.setBackground(new Color(109, 75, 209));
        record.setFocusPainted(false);
        record.setOpaque(true);
        record.setBounds(270,25,130,50);
        add(record);
        
        // ask for user name
        title.setText("Enter a unique player name below: ");
        title.setFont(new Font("Arial",Font.BOLD, 50));
        title.setForeground(new Color(48, 48, 48));
        title.setBounds(120,150,900,200);
        add(title);
    
        // user name input
        input = new JTextField(30);   
        input.setFont(new Font("Arial",Font.PLAIN, 45));
        input.setBounds(320,330,400,60);
        add(input);
        
        // bad input message (if any)
        message.setFont(new Font("Arial",Font.PLAIN, 27));
        message.setForeground(new Color(196, 24, 11));
        message.setBounds(320,395,500,30);
        add(message);

        
        // start button
        start.setFont(new Font("Arial",Font.PLAIN, 30));
        start.setForeground(new Color(255, 255, 255));
        start.setBackground(new Color(255, 92, 71));
        start.setFocusPainted(false);
        start.setOpaque(true);
        //start.setPreferredSize(new Dimension(200, 50));
        start.setBounds(390, 490, 250, 50);
        add(start);
        
		setOpaque(false);
	}
	
	// in game panel
	public void playing()
	{
		// clear
		removeAll(); 
		// absolute layout
		setLayout(null);
		// set bound
		setBounds(0,0,2000,1000);
				
		// play bgm
		Audios.bgm.loop();
		
		// back button
		back.setFont(new Font("Arial",Font.PLAIN, 20));
		back.setForeground(new Color(255, 255, 255));
		back.setBackground(new Color(96, 96, 96));
		back.setFocusPainted(false);
		back.setOpaque(true);
		back.setBounds(25,25,200,50);
		add(back);
		
        // record button
        record.setFont(new Font("Arial",Font.PLAIN, 20));
        record.setForeground(new Color(255, 255, 255));
        record.setBackground(new Color(109, 75, 209));
        record.setFocusPainted(false);
        record.setOpaque(true);
        record.setBounds(270,25,130,50);
        add(record);
		  
		// addition
		if(player.getType() == 0)
		{
			// question
			title.setText("What is "+ player.getProblem()[0] + " + " + player.getProblem()[1] + "?");
			
			// display operation
			JLabel operation = new JLabel("+"); 
			operation.setFont(new Font("Arial",Font.BOLD, 50));
			operation.setForeground(new Color(48, 48, 48));
			operation.setBounds(510,245,100,100);
	        add(operation);
	        
	        // display pictures
	        displayPic(player.getProblem()[0], Imgs.randoms, 130);
	        displayPic(player.getProblem()[1], Imgs.randoms, 265);
	        
		}
		// subtraction
		else if(player.getType() == 1)
		{
			title.setText("What is "+ player.getProblem()[0] + " - " + (-player.getProblem()[1])+ "?");
			
			// display operation
			JLabel operation = new JLabel("-"); 
			operation.setFont(new Font("Arial",Font.BOLD, 50));
			operation.setForeground(new Color(48, 48, 48));
			operation.setBounds(510,245,100,100);
			add(operation);
				        
			// display pictures
			displayPic(player.getProblem()[0], Imgs.randoms, 130);
			displayPic(-(player.getProblem()[1]), Imgs.randoms, 265);
		}
		// count
		else
		{
			title.setText("Count the number of " + Imgs.names[Imgs.randoms]+ ":");
			
			displayPic(player.getProblem()[0], Imgs.randoms, 200);
		}
		
		// question
        title.setFont(new Font("Arial",Font.BOLD, 50));
        title.setForeground(new Color(48, 48, 48));
        title.setBounds(190,35,900,200);
        add(title);
		
		// answer input
        input = new JTextField(30);   
        input.setFont(new Font("Arial",Font.PLAIN, 45));
        input.setBounds(330,440,400,60);
        add(input);
        
        // bad input message (if any)
        message.setFont(new Font("Arial",Font.PLAIN, 27));
        message.setForeground(new Color(196, 24, 11));
        message.setBounds(330,505,500,30);
        add(message);

        // submit button
        submit.setFont(new Font("Arial",Font.PLAIN, 30));
        submit.setForeground(new Color(255, 255, 255));
        submit.setBackground(new Color(255, 92, 71));
        submit.setFocusPainted(false);
        submit.setOpaque(true);
        //start.setPreferredSize(new Dimension(200, 50));
        submit.setBounds(450, 570, 150, 50);
        add(submit);
        
		setOpaque(false);
	}
	
	public void getResult()
	{
		// refresh record
		try
		{
			DisplayRecord rec = new DisplayRecord();
			int line = rec.compareRecord(player.getScore());
			if(line > -1)
				rec.newRecord(player.getName(), player.getScore(), line);
		}
		// exception
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Failed getting records. \n" + e); 
			System.exit(0);
		}

		// clear
		removeAll(); 
		// absolute layout
		setLayout(null);
		// set bound
		setBounds(0,0,2000,1000);
		
		// play sound effect
		Audios.finished.play();
		
		// back button
		back.setFont(new Font("Arial",Font.PLAIN, 20));
		back.setForeground(new Color(255, 255, 255));
		back.setBackground(new Color(96, 96, 96));
		back.setFocusPainted(false);
		back.setOpaque(true);
		back.setBounds(25,25,200,50);
		add(back);
		
		// title
		title.setText("Hi "+ player.getName()+ ", ");
        title.setFont(new Font("Arial",Font.BOLD, 60));
        title.setForeground(new Color(48, 48, 48));
        title.setBounds(120,90,900,200);
        add(title);
        JLabel title2 = new JLabel("here is your score: ");
        title2.setFont(new Font("Arial",Font.BOLD, 60));
        title2.setForeground(new Color(48, 48, 48));
        title2.setBounds(120,160,900,200);
        add(title2);

        // display score
		JLabel scr = new JLabel(player.getScore() + " out of 15");
		scr.setFont(new Font("Arial",Font.BOLD, 55));
		scr.setForeground(new Color(255, 56, 175));
		scr.setBounds(380,300,500,200);
        add(scr);
        
        // record button
        record.setFont(new Font("Arial",Font.PLAIN, 40));
        record.setForeground(new Color(255, 255, 255));
        record.setBackground(new Color(109, 75, 209));
        record.setFocusPainted(false);
        record.setOpaque(true);
        record.setBounds(400, 480, 250, 50);
        add(record, gbc);
        
        setOpaque(false);
	}
	
	// button actions
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); 
		if (source == learn) 
		{ 
			pageNum = 0; 
			thisFrame.Learn();
		}
		// new game
		else if (source == newGame)
		{
			thisFrame.Name();
		}
		// get records
		else if (source == record)
		{
			DisplayRecord rec = new DisplayRecord();
			
			rec.Display();
			rec.setVisible(true); 
		}
		// process user's answer to a question
		else if (source == submit)
		{
			try
			{
				Audios.bgm.stop();
				// get answer
				int answer = Validator.validateInteger(input.getText().trim());
				message.setText(" ");
				// grade
				if(player.checkAnswer(answer))
				{
					// correct
					Audios.correct.play();
					JOptionPane.showMessageDialog(null, "That's right!\n Good job!", "Result", 
							JOptionPane.INFORMATION_MESSAGE, Imgs.images[10]);
				}
				else
				{
					// incorrect
					Audios.incorrect.play();
					JOptionPane.showMessageDialog(null, "Oops! \nThe correct answer is " + player.getCorrectAns(), "Result", 
							JOptionPane.INFORMATION_MESSAGE, Imgs.images[11]);
				}
				// next problem
				if(player.getProblemNum() < 15)
				{
					// generate random image and question
					Imgs.randomImage();
					player.generateQuestion();
					thisFrame.InGame();
				}
				// finished
				else
				{
					thisFrame.Result();
				}
			}
			catch(Exception exp)
			{
				message.setText("Please enter a number(integer)");
				thisFrame.InGame();
			}
		}
		else if (source == back)
		{
			Audios.bgm.stop();
			message.setText(" ");
			thisFrame.TitlePage();
		}
		else if (source == start)
		{
			try 
			{
				// get and validate name
				player.setName(input.getText().trim());
				message.setText(Validator.validateName(player.getName()));
			}
			catch(Exception exp)
			{
				System.out.println("Name error?");
			}
			// bad name
			if(!(message.getText().contentEquals(" ")))
			{
				thisFrame.Name();
			}
			// ready to start
			else
			{
				player.reset();
				player.generateQuestion();
				thisFrame.InGame();
			}
		}
		else if (source == previous)
		{
			if(pageNum > 0)
			{
				--pageNum;
				thisFrame.Learn();
			}
		}
		// next page
		else
		{
			if(pageNum < 9)
			{
				++pageNum;
				thisFrame.Learn();
			}
		}
	}
	
	// display a picture for a number of times in line
		public void displayPic(int times, int index, int yposition)
		{
	        int xposition = 420 - (times - 1) * 50;
			for(int i = 0; i < times; i++)
			{
				JLabel picture = new JLabel(Imgs.images[index]);
				picture.setBounds(xposition,yposition,200,200);
				add(picture);
				xposition += 100; 
			}
		}
		
	// set the current frame
	public void setThisFrame(Frames thisFrame)
	{
		this.thisFrame = thisFrame; 
	}
}

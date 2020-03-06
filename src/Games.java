/*
 * Kcirde Santos
 * Kexin Zheng
 * CS-170-02
 * Final Project
 * 
 * Games class: 
 * processes the game
 * class variables include player name, score, current question number, question type, and problem info
 * class functions include getters and setters, random question generator, and answer checker
 */
import java.util.Random;

public class Games
{
	//class variables
	private String name; 
	private int score;
	private int problemNum;
	private int type;
	// current problem info
	private int[] prob;
	
	//constructor
	public Games()
	{
		name = "";
		score = 0;
		problemNum = 0;
		prob = new int[2];
	}
	// reset game
	public void reset()
	{
		score = 0; 
		problemNum = 0;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public int getType() {
		return type;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int[] getProblem() {
		return prob;
	}
	public int getProblemNum() {
		return problemNum;
	}
	public void setProblemNum(int problemNum) {
		this.problemNum = problemNum;
	}
	public int getCorrectAns()
	{
		return prob[0] + prob[1];
	}
	
	// generate random question (3 types)
	public void generateQuestion()
	{
		problemNum++;
		// random
		Random rand = new Random();
		// random type
		type = new Random().nextInt(3);
		// addition question
		if(type == 0)
		{
			//generate random number ranging from 1 to 5
			prob[0] = rand.nextInt(5) + 1;
			prob[1] = rand.nextInt(5) + 1; 
		}
		
		//randomly generate subtraction questions
		else if(type == 1)
		{
			//generate random number ranging from 2 to 10
			prob[0] = rand.nextInt(9) + 2;
			//the second number will be less than the first number so the result is not negative
			if(prob[0] == 2)
				prob[1] = -1;
			else
				prob[1] = -(rand.nextInt(prob[0]-1)+1); // negative number for process convenience
		}
		
		//randomly generate problem
		else
		{
			//generate random number ranging from 1 to 10
			prob[0] = rand.nextInt(10) + 1;
			prob[1] = 0;
		}
	}
	
	//check correctness of the answer
	public boolean checkAnswer(int player)
	{
		//add 1 to score if the user got the correct answer
		if (player == (prob[0] + prob[1]))
			score++;
		return player == (prob[0] + prob[1]); 
	}
}


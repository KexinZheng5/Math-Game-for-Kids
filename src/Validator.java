import javax.swing.JOptionPane;

/*
 * Kcirde Santos
 * Kexin Zheng
 * CS-170-02
 * Final Project
 * 
 * Validator class: 
 * for validating user input
 * contains function for validating name and answer
 */

public class Validator { 
	//validate name
	public static String validateName(String name)
	{
		//regular expression for name
		String regex = "\\s*";

		if((name.matches(regex)))
		{
			return "Please enter your name";
		}
		else if(name.contains("@"))
		{
			return "No @ in name";
		}
		try {
			if(new DisplayRecord().containName(name))
			{
				return "Name already exists the record";
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Failed getting records. \n" + e); 
			System.exit(0);
		}
		// valid
		return " ";
	}
	
	//validate integer
	public static int validateInteger(String num) throws NumberFormatException {
		int intdata = 0; //double data
		//validation
			try
			{
				//try to convert string to double
				intdata = Integer.parseInt(num);
			}
			//error: not a number
			catch(NumberFormatException e)
			{
				throw(e);
			}
		return intdata;
		}
}
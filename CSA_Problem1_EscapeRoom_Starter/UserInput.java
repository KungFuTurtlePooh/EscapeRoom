/**
 * Validate user input according to string array of acceptable inputs.
 * 
 * @author GShorr, PLTW
 * @version 4/16/2019
 */
import java.util.Scanner;

import javax.swing.JSpinner.DateEditor;

 public class UserInput
{
    public static int deductedPoints = 0;
    /**
     * Verifies that one of the string array provided as an argument will be
     * returned. 
     * <P>
     * Example usage:
     * String input = User.getValidInput("yes", "no", "y", "n");
     * <P>
     * Only yes, no, y, and n are valid inputs. If the user types anything
     * else, they will be prompted to re-enter.
     * <P>
     * Uppercase versions of the commands are acceptable and automatically
     * converted to lowercase prior to validating.
     * <P>
     * @return the valid command the user entered
     * 
     */
    public static String getValidInput(String[] validInputs)
    {
        deductedPoints = 0;
        String input = "";
        boolean valid = false;
        do
        {
            input = getLine().toLowerCase();
            for(String str : validInputs)
            {
                if(input.equals(str.toLowerCase()))
                    valid = true;
            }
            if(!valid) {
                System.out.print("Invalid input. Please try again\n>");
                // increases the deducted points if user inputs invalid input
                deductedPoints++;
            }

        }
        while(!valid);
        return input;
    }
    
    public static String getLine()
    {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    // Returns the -(deducted points), which is how many times a user
    // attempted to input invald command. Prints out how many points
    // were deducted as well.
    public static int getDeductedPoints() {
        if(deductedPoints != 0) {
            System.out.println("Points deducted due to Invalid Inputs: " + deductedPoints);
        }
        return -deductedPoints;
    }


  }
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This program outputs string of integers in a range of 1 to user Input that are divisible by either 3, 5, or both.
 */

//public class definition
public class Divisible
{
    //divisibleByThree() method takes user input as an integer and in a range of 1 and user input it returns all possible integers divisible by 3.
	private String divisibleByThree(int inputFromUser)
	{
        //initialize newOutputForThree string.
		String newOutputForThree = "";
        //For loop to catch every single integer within a range of 1 and user input.
		for (int i = 1; i <= inputFromUser; i++)
		{
            //If statement to calculate if an integer is divisible by 3.
        	if (i % 3 == 0)
			{
                //Appends every possible integer divisible by 3 in newOutputForThree string.
				newOutputForThree += ", " + i;
			}
		}
		
        //The first time a comma appears is redundant. So, it is replaced by an empty string.
		String finalOutput = newOutputForThree.replaceFirst(",", "");
        //If no integer in the range is divisible by 3, an appropriate message gets printed.
        if (finalOutput == "")
        {
            finalOutput = " No integer found";
        }
        //Returns finalOutput as a string.
		return finalOutput + ".";
	}

    //divisibleByFive() method takes user input as an integer and in a range of 1 and user input it returns all possible integers divisible by 5.
	private String divisibleByFive(int inputFromUser)
	{
		String newOutputForFive = "";

		for (int i = 1; i <= inputFromUser; i++)
		{
            //If statement to calculate if an integer is divisible by 5.
			if (i % 5 == 0)
			{
                //Appends every possible integer divisible by 5 in newOutputForThree string.
				newOutputForFive += ", " + i;
			}
		}

		String finalOutput = newOutputForFive.replaceFirst(",", "");
        if (finalOutput == "")
        {
            finalOutput = " No integer found";
        }

		return finalOutput + ".";
	}

    //divisibleByBothod takes user input as an integer and in a range of 1 and user input it returns all possible integers divisible by both 3 and 5.
	private String divisibleByBoth(int inputFromUser)
	{
		String newOutputForBoth = "";

		for (int i = 1; i <= inputFromUser; i++)
		{
            //If statement to calculate if an integer is divisible by both 3 and 5.
			if ((i % 5 == 0) && (i % 3 == 0))
			{
                //Appends every possible integer divisible by both 3 and 5 in newOutputForThree string.
				newOutputForBoth += ", " + i;
			}
		}


		String finalOutput = newOutputForBoth.replaceFirst(",", "");
        if (finalOutput == "")
        {
            finalOutput = " No integer found";
        }

		return finalOutput + ".";
	}

	
	public static void main(String[] args)
	{
		System.out.println("Input an integer and press enter.");
        
        //If the user doesn't input an integer, it gets caught and the user receives an appropriate error message.
        try 
        {
            //Create and declare a new Scanner object.
            Scanner userInput = new Scanner(System.in);
            //Store the user input in an integer n.
            Integer n = userInput.nextInt();
            //Check if the user input is between 1 and 200.
            if ((n >= 1) && (n <= 200))
            {   
                //Create and declare a new Divisible object instance.
                Divisible userOuputForThreeObject = new Divisible();
                //Call method divisibleByThree() and store the value in userOutputForThree string.
                String userOutputForThree = userOuputForThreeObject.divisibleByThree(n);
                //Print statement printing out integers divisible by 3.
                System.out.println("Divided by 3 ->" + userOutputForThree);

                Divisible userOuputForFiveObject = new Divisible();
                String userOutputForFive = userOuputForFiveObject.divisibleByFive(n);
                System.out.println("Divided by 5 ->" + userOutputForFive);

                Divisible userOuputForBothObject = new Divisible();
                String userOutputForBoth = userOuputForBothObject.divisibleByBoth(n);
                System.out.println("Divided by 3 and 5 ->" + userOutputForBoth);
            } 
            
            else 
            {
                //If the user inputs anything outside the range of [0, 200], output this message.
                System.out.println("Please input an integer between 1 and 200.");
            }
        } 

        catch (InputMismatchException e) 
        {
        System.out.println("Error: You did not enter an integer.");
        }
	}
}
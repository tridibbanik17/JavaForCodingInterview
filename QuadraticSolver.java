/*
 * This program solves a quadratic equation and outputs the roots if exists.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuadraticSolver
{
	private Double a;
	private Double b;
	private Double c;

    //quadOutOne() method takes three real numbers and finds roots of the quadratic equation.
	public static String quadOutOne(Double a, Double b, Double c)
	{
        //b*b-4*a*c < 0 or a = 0 would give undefined values.
		if ((b*b-4*a*c < 0) || (a==0))
		{
			String invalidRoot = "Undefined";
			return invalidRoot;
		}

		else
		{
			Double firstOutput = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
            //Round the root to two sig. fig. after decimal point and Convert that to a string.
			String firstOutputString = String.format("%.2f", firstOutput);
			return firstOutputString;
		}
	}

    //quadTwo() finds the second possible root.
	public static String quadOutTwo(Double a, Double b, Double c)
	{
		if ((b*b-4*a*c < 0) || (a==0))
		{
			String invalidRoot = "Undefined";
			return invalidRoot;
		}
		else
		{
			Double secondOutput = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
			String secondOutputString = String.format("%.2f", secondOutput);
			return secondOutputString;
		}
	}

    //isInputWithinRange() method returns true or false depending on whether a value is between -100 and 100.
	public static Boolean isInputWithinRange(Double userInput)
	{
		if ((userInput <= 100) & (userInput >= -100))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		//try-catch block to catch invalid user input type.
        try
		{
			System.out.println("Enter the value of the first coefficient and press enter.");
            //Create and declare a new Scanner object.
			Scanner firstInputObject = new Scanner(System.in);
            //Read the user input as a double value and store it to firstInput.
			Double firstInput = firstInputObject.nextDouble();

			System.out.println("Enter the value of the second coefficient and press enter.");
			Scanner secondInputObject = new Scanner(System.in);
			Double secondInput = secondInputObject.nextDouble();

			System.out.println("Enter the value of the third coefficient and press enter.");
			Scanner thirdInputObject = new Scanner(System.in);
			Double thirdInput = thirdInputObject.nextDouble();

            //Check if the user input is between -100 and 100 by calling isInputWithinRange() method.
			if (!(QuadraticSolver.isInputWithinRange(firstInput)) || !(QuadraticSolver.isInputWithinRange(secondInput)) || !(QuadraticSolver.isInputWithinRange(thirdInput)))
			{
				System.out.println("Please enter a value between -100 and 100.");
			}
			else
			{
                //Compare the return value of quadOutOne() method to find out if any root exists for the current set of user input values.
				if (QuadraticSolver.quadOutOne(firstInput, secondInput, thirdInput) == "Undefined")
				{
					System.out.println("The equation has no real roots.");
				}
				else
				{
					System.out.printf("For" + " a=" + firstInput + ", b=" + secondInput + " and" + " c=" + thirdInput + ", the roots are " + QuadraticSolver.quadOutOne(firstInput, secondInput, thirdInput) + " and " + QuadraticSolver.quadOutTwo(firstInput,secondInput,thirdInput) + "\n");	
				}
			}			
		}
		
		catch (InputMismatchException e) 
        {
            System.out.println("Error: You did not enter a real valued coefficient.");
			System.out.println("Please enter a real number.");
        }
	}
}
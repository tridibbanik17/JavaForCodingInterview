import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *This program converts a decimal integer between -1000 and 1000 to an octal integer.
 * Sample input and output:
 * Input: 8
 * Output: 10
 * Another sample input and output:
 * Input: 255
 * Output: 377
 */

//public class definition
public class DecimalToOctal { 
    //octalConverter method definition that takes an integer input (i.e., a decimal integer) and outputs the corresponding octal integer.
    private Integer octalConverter(int userInput)
    {
        Integer quotient = userInput;
        Integer remainder = userInput;
        //Create and declare two StringBuilder object for string modifications.
        StringBuilder listOfRemainders = new StringBuilder();
        StringBuilder octalOutput = new StringBuilder();
        
        //while loop runs until quotient value reaches zero. 
        while (quotient != 0)
        {   
            //remainder is used to determine octal integer value later on.
            remainder = quotient % 8; 
            //Divide by 8 because octal numbers are base 8.
            quotient = quotient / 8;
            //Append the value of remainder after each iteration.
            listOfRemainders.append(remainder);

        }

        //for loop to reverse the value of listOfRemainders variable.
        for (int i = 0; i < (listOfRemainders.length()); i++)
        {
            //Append one character of listOfRemainders variable at a time in reverse order.
            octalOutput.append(listOfRemainders.charAt(listOfRemainders.length() - 1 - i));
        }  

        //Convert StringBuilder type to String type and then convert string type to an integer.
        Integer octalInteger = Integer.parseInt(octalOutput.toString());
        return octalInteger;
    }

    public static void main(String[] args) {
        System.out.println("Input the decimal number as an integer and press enter.");

        //If the user doesn't input an integer, it gets caught and the user receives an appropriate error message.
        try
        {
            //Create and declare a new Scanner object instance. The user input gets stored in variable x.
            Scanner userInputObject = new Scanner(System.in);
            Integer x = userInputObject.nextInt();

            //If user inputs any integer above 1000 or below -1000, user will be asked to enter an integer between -1000 and 1000.
            if ((x > 1000) || (x < -1000))
            {
                System.out.println("Please enter an integer between -1000 and 1000.");
            }

            //If user input is between -7 and 7, the decimal value and the octal value are the same.
            else if ((x < 8) && (x > -8))
            {
                System.out.println("The octal number is " + x);
            }

            //If the user inputs an integer between 8 and 1000, octalConverter() method will be called.
            else if ((x > 7) && (x < 1001))
            {
                //Create and declare a new object instance of DecimalToOctal class.
                DecimalToOctal y = new DecimalToOctal();
                //Print out the converted octal integer y by calling the octalConverter() method.
                System.out.println("The octal number is " + y.octalConverter(x) + ".");
            }

            //If the user inputs an integer between -8 and -1000, octalConverter() method will be called but the method argument will be the absolute value of user input.
            else if ((x < -7) && (x > -1001))
            {
                //Take the absolute value of the user input using the java.lang.Math library.
                x = Math.abs(x);
                //Create and declare a new object instance of DecimalToOctal class.
                DecimalToOctal y = new DecimalToOctal();
                //Print out the converted octal integer y by calling the octalConverter() method. 
                System.out.println("The octal number is " + "-" + y.octalConverter(x) + ".");
            }
        }

        catch (InputMismatchException e) 
        {
        System.out.println("Error: You did not enter an integer.");
        }
    }
}
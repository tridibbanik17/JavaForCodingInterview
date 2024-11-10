
/**
 * Author: Tridib Banik, Student @ McMaster University, Software Engineering
 * This java program takes a String as an input and outputs an encoded string.
 * All consecutive characters that are the same, are written once with the number of counts.
 * For example, bbbffffa is written as b3f4a1.
 */

public class RunLengthEncoder {

    // The attribute of the class is a private string.
    private String str = "bbbffffa";

    // Getter Method.
    public String getString() {
        return this.str;
    }

// Commented version is the hard way to solve the problem.
/*
    public String encoder(String a) {
        StringBuilder stringBuilderObj = new StringBuilder();
        StringBuilder encodedString = stringBuilderObj.append("");
        int newCount = 0;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i - 1) != a.charAt(i)) {
                encodedString.append(String.valueOf(a.charAt(i-1)) + String.valueOf(i - newCount));
                newCount = i;
                while (i == (a.length() - 1)) {
                    if (a.charAt(a.length() - 1) != a.charAt(a.length() - 2)) {
                        encodedString.append(String.valueOf(a.charAt(a.length() - 1)) + String.valueOf(1));
                        break;
                    }
                }  
            }

            else {
                while (i == (a.length() - 1)) {
                    if (a.charAt(a.length() - 1) == a.charAt(a.length() - 2)) {
                        encodedString.append(String.valueOf(a.charAt(a.length() - 1)) + String.valueOf((i + 1) - newCount));
                        break;
                    }
                }
            }
        }
        return String.valueOf(encodedString);
    }

    */

    // This is the easy way to solve the problem.
    // lengthEncoder() method takes str : String as an input. 
    public String lengthEncoder(String str) {
        //Handling exception.
        if (str.length() == 0) {
            throw new IllegalArgumentException("The string cannot be empty.");
        }
        // StringBuilder object to avoid creating multiple object. Good for memory efficiency. 
        StringBuilder newStringObject = new StringBuilder();

        // For loop to iterate through each character of the string.
        for (int i = 0; i < str.length(); i++) {
            // Initialize counter at 1 because 
            int counter = 1;

            // If two consecutive characters are the same, both the counter and the iteration increment by 1.
            while ((i < str.length() - 1) && (str.charAt(i) == str.charAt(i + 1))) {
                counter += 1; 
                i++;
            }
            /**
             * If two consecutive characters are not the same, 
             * newStringObject gets updated by the most recent consecutive character 
             * and the number of its occurences.
             */
            newStringObject.append(String.valueOf(str.charAt(i)) + counter);
        }

        // Return the final encoded string.
        return String.valueOf(newStringObject);
    }

    public static void main(String[] args) {
        // New object instance of RunLengthEncoder class. 
        RunLengthEncoder newStringObject = new RunLengthEncoder();
        System.out.println("Input string is: " + newStringObject.getString());
        System.out.println("New encoded string is: " + newStringObject.lengthEncoder(newStringObject.getString()));
    }
}
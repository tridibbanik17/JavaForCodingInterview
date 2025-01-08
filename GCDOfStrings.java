/*
 * For two strings s and t, "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2
 * Sample input and output:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 */

import java.util.Scanner;

class GCDOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // If concatenating in one order does not equal the other, they don't have a common divisor
        if (!(str1+str2).equals(str2+str1)) {
            return "";
        }
        // Converting str1 and str2 to integers by getting their size.
        int x = str1.length();
        int y = str2.length();

        // Find the gcd of two integers x and y.
        while(y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        // x is the greatest common divisor of integers x and y.
        // Return the substring of str1 with the length x.
        return str1.substring(0, x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the two strings
        System.out.println("Enter the first string (str1): ");
        String str1 = scanner.nextLine();

        System.out.println("Enter the second string (str2): ");
        String str2 = scanner.nextLine();

        // Create an instance of the solution class and calculate the result
        GCDOfStrings solution = new GCDOfStrings();
        String result = solution.gcdOfStrings(str1, str2);

        // Output the result
        System.out.println("The greatest common divisor string is: " + result);

        scanner.close();
    }
}
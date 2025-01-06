import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

class HappyNumber {

    /**
     * Determines if a number is a "happy number."
     * A happy number eventually reaches 1 when replaced repeatedly
     * by the sum of the squares of its digits. If it enters a cycle, it's not happy.
     * 
     * @param n The number to check.
     * @return True if the number is happy, false otherwise.
     */
    public boolean isHappy(int n) {
        // Use a set to detect cycles in the sequence of results
        Set<Integer> seenNumbers = new HashSet<>();
        
        // Continue processing until we find a happy number (1) or detect a cycle
        while (n != 1) {
            int result = 0;

            // Calculate the sum of squares of the digits of the current number
            while (n > 0) {
                int digit = n % 10;         // Extract the last digit
                result += digit * digit;   // Add the square of the digit to the result
                n /= 10;                   // Remove the last digit
            }

            // Check if the result has been seen before (cycle detection)
            if (seenNumbers.contains(result)) {
                return false; // A cycle is detected, so the number is not happy
            }

            // Add the current result to the set and continue processing
            seenNumbers.add(result);
            n = result;
        }

        // If we reach 1, the number is happy
        return true;
    }

    public static void main(String[] args) {
        // Create an instance of the HappyNumber class
        HappyNumber happyNumber = new HappyNumber();
        
        // New Scanner object
        Scanner scanner = new Scanner(System.in);

        // Test case
        System.out.println("Enter the number: ");
        int testNumber1 = scanner.nextInt(); // Example of a happy number, i.e., 19 and example of a non-happy number, i.e., 2

        // Print results of the test cases
        System.out.println("Is " + testNumber1 + " a happy number? " + happyNumber.isHappy(testNumber1)); // Expected: true
    }
}

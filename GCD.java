// Class GCD contains methods to find the Greatest Common Divisor (GCD) of the largest number and the smallest number from an array of integers.
public class GCD {

    /**
     * This method calculates the GCD of the largest and smallest numbers in the given array.
     * @param nums an array of integers.
     * @return the GCD of the largest and smallest integers in the array.
     */
    public int findGCD(int[] nums) {
        // Find the largest number in the array.
        int largest = nums[0];
        for (int i : nums) {
            if (i > largest) {
                largest = i;
            }
        }

        // Find the smallest number in the array.
        int smallest = nums[0];
        for (int j : nums) {
            if (j < smallest) {
                smallest = j;
            }
        }

        // Use the Euclidean algorithm to find the GCD of the largest and smallest numbers.
        while (smallest != 0) {
            int temp = smallest;
            smallest = largest % smallest;
            largest = temp;
        }

        // Return the GCD.
        return largest;
    }

    /**
     * The main method serves as the entry point of the program.
     * It demonstrates the usage of the findGCD method.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        GCD gcdFinder = new GCD();

        // Example array.
        int[] nums = {24, 36, 48, 60};

        // Calculate and display the GCD.
        int gcd = gcdFinder.findGCD(nums);
        System.out.println("The GCD of the array is: " + gcd);
    }
}

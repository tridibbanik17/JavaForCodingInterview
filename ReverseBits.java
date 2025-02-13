
/**
 * This program reverses the bits of a 32-bit unsigned integer.
 * 
 * Given an input integer 'n', it processes the bits in reverse order 
 * and returns the integer representation of the reversed bit sequence.
 *
 * Sample input & output:
 * Input:  n = 00000010100101000001111010011100 (43261596 in decimal)
 * Output: 964176192 (00111001011110000010100101000000 in binary)
 * 
 * Sample input & output:
 * Input:  n = 11111111111111111111111111111101 (4294967293 in decimal)
 * Output: 3221225471 (10111111111111111111111111111111 in binary)
 */

import java.lang.Math;
import java.util.Scanner;
public class ReverseBits {
    public static int reverseBits(int n) {
        // Initialize the output.
        int output = 0;
        // Interate from i= 0 to 31 because the output needs to be 32 bits.
        for (int i = 0; i < 32; i++) {
            output <<= 1;  // Shift output left by 1 to make space for the next bit.
            output |= (n & 1);  // Extract the least significant bit (LSB) of 'n' and set it in 'output'.
            n >>>= 1;  // Perform an unsigned right shift on 'n' to process the next bit.
        }
        return output;
    }

    // Hard way of solving the problem
    // public static int reverseBits(int n) {
    //     StringBuilder inputBinary = new StringBuilder("");
    //     while (inputBinary.length() < 32) {
    //         if (n % 2 == 1) {
    //             inputBinary.insert(0, "1");
    //             n /= 2;
    //         }
    //         else if (n % 2 == 0) {
    //             inputBinary.insert(0, "0");
    //             n /= 2;
    //         }
    //     }

    //     String binary = inputBinary.toString();
    //     System.out.println("Binary input is: " + binary);
    //     StringBuilder reverse = new StringBuilder("");
    //     for (int i = binary.length() - 1; i >= 0; i--) {
    //         reverse.append(String.valueOf(binary.charAt(i)));
    //     }
    //     String revStr = reverse.toString();
    //     System.out.println("Reverse Binary is: " + revStr);
    //     int output = 0;
    //     int index = 0;
    //     for (int j = revStr.length() - 1; j >= 0; j--) {
    //         output += Integer.parseInt(String.valueOf(revStr.charAt(j))) * Math.pow(2, index);
    //         index++;
    //     }
    //     return output;
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the 32 bits unsigned integer: ");
        Integer userInput = scanner.nextInt();
        System.out.println("The reversed integer is " + reverseBits(userInput));
    }
}
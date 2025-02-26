import java.util.Scanner;

/*
Given a 32-bit integer num, return a string representing its hexadecimal representation.
For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not 
be any leading zeros in the answer except for the zero itself.

Note: Use of any built-in library method to directly solve this problem is forbidden.

Example 1:
Input: num = 26
Output: "1a"

Example 2:
Input: num = -1
Output: "ffffffff"
*/

class HexConversion {
    public String toHex(int num) {
        StringBuilder sb1 = new StringBuilder(""); // Stores the binary representation in reverse order
        StringBuilder sb2 = new StringBuilder(""); // Stores the final 32-bit binary representation

        // Convert to unsigned 32-bit representation (handles negative numbers correctly)
        long unsignedNum = num & 0xFFFFFFFFL; 

        // Convert number to binary (in reverse order)
        while (unsignedNum > 0) {
            sb1.append(unsignedNum % 2); // Append remainder (0 or 1)
            unsignedNum /= 2; // Divide by 2
        }

        // Calculate the number of leading zeros required to make it a 32-bit representation
        int zeroes = 32 - sb1.length();
        int zeroCount = zeroes;

        // Append leading zeros to sb2
        while (sb2.length() != zeroes) {
            sb2.append("0");
            zeroCount--;
            if (zeroCount == 0) {
                break;
            }
        }

        // Append the binary representation from sb1 in correct order
        for (int i = sb1.length() - 1; i >= 0; i--) {
            sb2.append(sb1.charAt(i));
        }

        // Print the 32-bit binary equivalent
        System.out.println("The equivalent 32 bit binary number is: " + sb2.toString());

        StringBuilder sb3 = new StringBuilder(""); // Temporary 4-bit storage for hex conversion
        StringBuilder result = new StringBuilder(""); // Stores final hexadecimal value
        int count = 0; // Counter to track groups of 4 bits

        // Convert every 4 binary digits into a single hexadecimal digit
        for (int j = 0; j < sb2.length(); j++) {
            sb3.append(sb2.charAt(j)); 
            count++;

            // Once we have 4 binary digits, map them to their hex equivalent
            if (count % 4 == 0) {
                switch (sb3.toString()) {
                    case "0000": result.append("0"); break;
                    case "0001": result.append("1"); break;
                    case "0010": result.append("2"); break;
                    case "0011": result.append("3"); break;
                    case "0100": result.append("4"); break;
                    case "0101": result.append("5"); break;
                    case "0110": result.append("6"); break;
                    case "0111": result.append("7"); break;
                    case "1000": result.append("8"); break;
                    case "1001": result.append("9"); break;
                    case "1010": result.append("a"); break;
                    case "1011": result.append("b"); break;
                    case "1100": result.append("c"); break;
                    case "1101": result.append("d"); break;
                    case "1110": result.append("e"); break;
                    case "1111": result.append("f"); break;
                }
                sb3.setLength(0); // Clear sb3 for the next 4-bit group
            }
        }

        String resultString = result.toString();

        // If the hexadecimal result is all zeros, return "0"
        if (resultString.equals("00000000")) {
            return "0";
        }

        // Remove leading zeros from the final hex string
        int start = 0;
        while (start < resultString.length() && resultString.charAt(start) == '0') {
            start++;
        }

        return resultString.substring(start); // Return the trimmed hex value
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the integer: ");
        int input = scanner.nextInt();
        scanner.close();

        HexConversion hc = new HexConversion();
        System.out.println("The equivalent hexadecimal number is: " + hc.toHex(input));
    }
}

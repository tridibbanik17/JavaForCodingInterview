/*
 * Given two binary strings a and b, return their sum as a binary string.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
**/

public class BinaryAddition {
    
    public String addBinary(String a, String b) {
        StringBuilder revA = new StringBuilder();
        StringBuilder revB = new StringBuilder();

        // Reverse both strings
        for (int i = a.length() - 1; i >= 0; i--) {
            revA.append(a.charAt(i));
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            revB.append(b.charAt(i));
        }

        // Convert to char arrays
        char[] arrA = revA.toString().toCharArray();
        char[] arrB = revB.toString().toCharArray();

        int maxLength = Math.max(arrA.length, arrB.length);
        char carry = '0';  // '0' represents no carry, '1' represents carry
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            char bitA = (i < arrA.length) ? arrA[i] : '0';
            char bitB = (i < arrB.length) ? arrB[i] : '0';

            // Binary addition: bitA + bitB + carry
            int sum = (bitA - '0') + (bitB - '0') + (carry - '0');

            // Determine the result and carry
            if (sum == 0) {
                result.append('0');
                carry = '0';
            } else if (sum == 1) {
                result.append('1');
                carry = '0';
            } else if (sum == 2) {
                result.append('0');
                carry = '1';
            } else if (sum == 3) {
                result.append('1');
                carry = '1';
            }
        }

        // If there's a carry left after the last addition, append it
        if (carry == '1') {
            result.append('1');
        }

        // Reverse the result to get the final binary number
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        // Test the addBinary method
        BinaryAddition binaryAddition = new BinaryAddition();

        if (args.length != 2) {
            System.out.println("Usage: java BinaryAddition <binaryString1> <binaryString2>");
            return;
        }

        String a = args[0];
        String b = args[1];
        
        // Call the addBinary method and print the result
        String result = binaryAddition.addBinary(a, b);
        System.out.println("Sum: " + result);
    }
}

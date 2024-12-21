// This Java program converts any roman numeral to integer.
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// Exceptions:
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Constraints: 1 <= s.length <= 15

class RomanToInteger {
    public int romanToInt(String s) {
        // Constraints
        if ((s.length() > 15) || (s.length() < 1)) {
            throw new IllegalArgumentException("The string length must be between 1 and 15.");
        }

        // initialize the result
        int result = 0;
        // For loop to iterate through each character of the roman numeral.
        for (int i = 0; i < s.length(); i++) {
            // I represents 1
            if (s.charAt(i) == 'I') {
                result += 1;
            }
            
            if (s.charAt(i) == 'V') {
                // V represents 5, but IV represents 4. Since 1 representing I is already added to result, add 3 more to add a total 4 to the result.
                if ((i != 0) && (s.charAt(i - 1) == 'I')) {
                    result += 3;
                    continue;
                }

                else {
                    result += 5;
                }
            }

            if (s.charAt(i) == 'X') {
                // X represents 10, but IX represents 9. Since 1 representing I is already added to result, add 8 more to add a total 9 to the result.
                if ((i != 0) && (s.charAt(i - 1) == 'I')) {
                    result += 8;
                    continue;
                }
                else {
                    result += 10;
                }
            }

            if (s.charAt(i) == 'L') {
                // L represents 50, but XL represents 40. Since 10 representing X is already added to result, add 30 more to add a total 40 to the result.
                if ((i != 0) && (s.charAt(i - 1) == 'X')) {
                    result += 30;
                    continue;
                }
                else {
                    result += 50;
                }
            }

            if (s.charAt(i) == 'C') {
                // C represents 100, but XC represents 90. Since 10 representing X is already added to result, add 80 more to add a total 90 to the result.
                if ((i != 0) && (s.charAt(i - 1) == 'X')) {
                    result += 80;
                    continue;
                }
                else {
                    result += 100;
                }
            }

            if (s.charAt(i) == 'D') {
                // D represents 500, but CD represents 400. Since 100 representing C is already added to result, add 300 more to add a total 400 to the result.
                if ((i != 0) && (s.charAt(i - 1) == 'C')) {
                    result += 300;
                    continue;
                }
                else {
                    result += 500;
                }
            }   

            if (s.charAt(i) == 'M') {
                // M represents 1000, but CM represents 900. Since 100 representing C is already added to result, add 800 more to add a total 900 to the result.
                if ((i != 0) && (s.charAt(i - 1) == 'C')) {
                    result += 800;
                    continue;
                }
                else {
                    result += 1000;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Create and instantiate a new object of RomanToInteger class.
        RomanToInteger obj = new RomanToInteger();
        // Call romanToInt() method with three different inputs and print outputs for each.
        System.out.println("The integer for 'III' is " + obj.romanToInt("III"));
        System.out.println("The integer for 'LVIII' is " + obj.romanToInt("LVIII"));
        System.out.println("The integer for 'MCMXCIV' is " + obj.romanToInt("MCMXCIV"));
    }
}
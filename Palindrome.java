// This Java program checks if a string is a valid palindrome.
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. 
// Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

public class Palindrome {
    public boolean isPalindrome(String s) {
        // Convert all letters to lowercase, remove all punctuation and whitespace.
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0; // initialize left index
        int right = str.length() - 1; // initialize right index

        while (left < right) {
            // If the left and right index don't match, they are not palindrome.
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++; // increment of left index
            right--; // decrement of right index
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        System.out.println("Which of the following strings are palindrome?");
        System.out.println("A man, a plan, a canal: Panama -> " + obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("race a car -> " + obj.isPalindrome("race a car"));
        System.out.println(" ra dar -> " + obj.isPalindrome(" ra dar"));
    }
}
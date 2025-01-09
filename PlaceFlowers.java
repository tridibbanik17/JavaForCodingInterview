/*
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * Sample inputs and outputs:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 */
import java.util.Scanner;
class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Check if there's only one spot and it's empty
        if ((n == 1) && (flowerbed.length == 1) && (flowerbed[0] == 0)) {
            return true;
        }
        // Check if there are two spots and both are empty
        if ((n == 1) && (flowerbed.length == 2) && (flowerbed[0] == 0) && (flowerbed[1] == 0)){
            return true;
        }
        // Check if there are three spots and all are empty
        if ((n == 2) && (flowerbed.length == 3) && (flowerbed[0] == 0) && (flowerbed[1] == 0) && (flowerbed[2] == 0)) {
            return true;
        }
        // Iterate through the flowerbed to find spots to plant flowers
        for (int i = 1; i < flowerbed.length - 1; i++) {
            // Check the first two spots
            if ((i == 1) && (flowerbed[i-1] == 0) && (flowerbed[i] == 0)) {
                flowerbed[i-1] = 1;
                n--;
            }
            // Check the middle spots
            else if ((flowerbed[i-1] == 0) && (flowerbed[i+1] == 0) && (flowerbed[i] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            // Check the last two spots
            else if ((i == flowerbed.length - 2) && (flowerbed[i] == 0) && (flowerbed[i+1] == 0)) {
                flowerbed[i+1] = 1;
                n--;
            }
        }
        // If all required flowers are planted, return true
        if (n <= 0) {
            return true;
        }
        // Otherwise, return false
        return false;
    }

    public static void main(String[] args) {
        // Create a new instance of PlaceFlowers class.
        PlaceFlowers obj = new PlaceFlowers();
        // Create a new Scanner object.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of plots in the flowerbed: ");
        // Length of flowerbed array.
        int plotCount = scanner.nextInt();
        System.out.println("Enter each plots value (0 or 1) one by one: ");
        // Create a new integer array with length plotCount.
        int[] flowerbed = new int[plotCount];
        // Read each value from stdin and assign them to the integer array in order.
        for (int i = 0; i < plotCount; i++) {
            flowerbed[i] = scanner.nextInt();
        }
        System.out.println("Enter the number of new flowers: ");
        // Number of new flowers
        int n = scanner.nextInt();
        // Output
        System.out.println(obj.canPlaceFlowers(flowerbed, n)); 
    }
}
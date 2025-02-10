
/* Given strings jewels representing the types of stones that are jewels, 
 * and stones representing the stones that exist. 
 * Each character in stones is a type of stone that exist. 
 * Determine how many of the stones that exist are also jewels.

 * Letters are case-sensitive, so "a" is considered a different type of stone from "A".

 * Sample inputs and outputs
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3

 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
**/

import java.util.Scanner;
class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int jewelCount = 0; jewelCount < jewels.length(); jewelCount++) {
            for (int stoneCount = 0; stoneCount < stones.length(); stoneCount++) {
                if (jewels.charAt(jewelCount) == stones.charAt(stoneCount)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones obj = new JewelsAndStones();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the jewels String: ");
        String jewelsStr = scanner.nextLine();
        System.out.println("Enter the stones String: ");
        String stonesStr = scanner.nextLine();
        System.out.println("The number of stones that are also jewels is " + obj.numJewelsInStones(jewelsStr, stonesStr) + ".");
    }
}
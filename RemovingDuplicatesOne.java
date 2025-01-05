// This Java program removes duplicates from a sorted array.
// The maximum number of occurrences of each integer is one 
// If two or more occurrences found, remove them.
// if there are k elements after removing the duplicates, return k as an integer.

import java.util.Arrays;

public class RemovingDuplicatesOne {
    public int duplicateEraser(int[] nums) {
        if (nums.length == 0)
            return 0;

        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RemovingDuplicatesOne newObj = new RemovingDuplicatesOne();
        int[] inputArray = {1,1,1,2,2,3,3,3};
        System.out.println("The input integer array is " + Arrays.toString(inputArray));
        System.out.println("The number of elements after removing the duplicates is " + newObj.duplicateEraser(inputArray) + ".");
    }

}

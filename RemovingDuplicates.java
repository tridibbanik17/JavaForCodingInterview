// This Java program removes duplicates from a sorted array.
// The maximum number of occurrences of each integer is two. 
// If three or more occurrences found, remove them.
// if there are k elements after removing the duplicates, return k as an integer

public class RemovingDuplicates {
    public int duplicateEraser(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int k = 2;
        for (int num = 2; num < nums.length; num++) {
            if (nums[num] != nums[k - 2]) {
                nums[k] = nums[num];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemovingDuplicates newObj = new RemovingDuplicates();
        int[] inputArray = {1,1,1,2,2,3,3,3};
        System.out.println("The input integer array is " + inputArray);
        System.out.println("The number of elements after removing the duplicates is " + newObj.duplicateEraser(inputArray) + ".");
    }

}


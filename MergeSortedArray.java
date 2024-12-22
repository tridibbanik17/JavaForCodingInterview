import java.util.Arrays;
// Two integer arrays nums1 and nums2 are given
// Arrays are sorted in non-decreasing order
// Two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// The Java program merges nums1 and nums2 into a single array sorted in non-decreasing order.
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // constraints
        if (nums1.length != (m+n)) {
            throw new IllegalArgumentException("The length of nums1 must be the sum of m and n.");
        }

        if (nums2.length != n) {
            throw new IllegalArgumentException("The length of nums2 must be equal to n.");
        }

        if ((m < 0) || (m > 200)) {
            throw new IllegalArgumentException("m must be greater than or equal to 0 and m must be less than or equal to 200.");
        }

        if ((n < 0) || (n > 200)) {
            throw new IllegalArgumentException("n must be greater than or equal to 0 and n must be less than or equal to 200.");
        }
    
        if (((m+n) < 1) || ((m+n) > 200)) {
            throw new IllegalArgumentException("m+n must be greater than or equal to 1 or less than or equal to 200.");
        }

        for (int i = 0; i < nums1.length; i++) {
            if ((nums1[i] > 1000000000) || (nums1[i] < -1000000000)){
                throw new IllegalArgumentException("-10^9 <= each element of nums1 <= 10^9");
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if ((nums2[j] > 1000000000) || (nums2[j] < -1000000000)){
                throw new IllegalArgumentException("-10^9 <= each element of nums2<= 10^9");
            }
        }

        // // Start filling nums1 from the back
        // int p = m + n - 1;

        // // Compare elements from nums1 and nums2 and place the larger one
        // while (m > 0 && n > 0) {
        //     if (nums1[m - 1] > nums2[n - 1]) {
        //         nums1[p--] = nums1[--m];
        //     } else {
        //         nums1[p--] = nums2[--n];
        //     }
        // }

        // // If there are any remaining elements in nums2, copy them
        // while (n > 0) {
        //     nums1[p--] = nums2[--n];
        // }

        int temp_m = m;

        for (int item : nums2) {
            nums1[temp_m] = item;
            temp_m++;
        }

        Arrays.sort(nums1);
    }
    
    public static void main(String[] args) {
        // Create an instance of MergeSortedArray
        MergeSortedArray merger = new MergeSortedArray();

        // Example 1
        int[] nums1 = {1, 2, 3, 0, 0, 0}; // nums1 with space for n elements
        int m = 3; // Number of initial elements in nums1
        int[] nums2 = {2, 5, 6}; // nums2
        int n = 3; // Number of elements in nums2

        // Call the merge method
        merger.merge(nums1, m, nums2, n);

        // Output the result
        System.out.println("Merged array: " + Arrays.toString(nums1));

        // Example 2
        int[] nums1_2 = {1, 0}; // nums1 with space for n elements
        int m2 = 1; // Number of initial elements in nums1
        int[] nums2_2 = {2}; // nums2
        int n2 = 1; // Number of elements in nums2

        // Call the merge method
        merger.merge(nums1_2, m2, nums2_2, n2);

        // Output the result
        System.out.println("Merged array: " + Arrays.toString(nums1_2));

        // Example 3
        int[] nums1_3 = {0}; // nums1 with space for n elements
        int m3 = 0; // Number of initial elements in nums1
        int[] nums2_3 = {1}; // nums2
        int n3 = 1; // Number of elements in nums2

        // Call the merge method
        merger.merge(nums1_3, m3, nums2_3, n3);

        // Output the result
        System.out.println("Merged array: " + Arrays.toString(nums1_3));
    }
}

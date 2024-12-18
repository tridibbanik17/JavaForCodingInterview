/* Given a sorted array of distinct integers and a target value, return the index if the target
is found. If not, return the index where it would be if it were inserted in order. */

class Solution {
    public int searchInsert(int[] nums, int target) {
        // The index of the leftmost and rightmost element.
        int left = 0, right = nums.length - 1;

        // left is smaller than right always needs to be true in binary search
        while (left <= right) {
            // Take the average of the leftmost and the rightmost 
            int mid = left + (right - left) / 2; // To prevent overflow
            // If the element at the middle index is the target value, then the middle index is found.
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }

        // If the target element is not found, `left` points to the insertion index
        return left;
    }
}

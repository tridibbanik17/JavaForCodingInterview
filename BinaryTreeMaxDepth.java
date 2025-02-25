/**
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 */

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeMaxDepth {
    // Method to calculate the maximum depth of a binary tree
    public int maxDepth(TreeNode root) {
        // Base case: If the root is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum of the two depths plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Main method for testing the functionality
    public static void main(String[] args) {
        // Creating a binary tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        // Creating an instance of BinaryTreeMaxDepth and testing maxDepth
        BinaryTreeMaxDepth solution = new BinaryTreeMaxDepth();
        int depth = solution.maxDepth(root);

        // Output the result
        System.out.println("Maximum depth of the binary tree: " + depth);

        // Additional test case: [1, null, 2]
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Maximum depth of the second binary tree: " + solution.maxDepth(root2));
    }
}

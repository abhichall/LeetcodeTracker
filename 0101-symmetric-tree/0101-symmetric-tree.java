/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    // Main class containing the solution
    public boolean isSymmetric(TreeNode root) {
        // Method to determine if the binary tree is symmetric
        if (root == null) {
            // Check if the tree is empty
            return true; // An empty tree is symmetric by definition
        }
        // End of if block

        return isMirror(root.left, root.right);
        // Check if the left and right subtrees are mirror images
    }
    // End of isSymmetric method

    private boolean isMirror(TreeNode left, TreeNode right) {
        // Helper method to compare two subtrees
        if (left == null && right == null) {
            // If both nodes are null
            return true; // They are mirrors, so return true
        }
        // End of if block

        if (left == null || right == null) {
            // If one node is null and the other is not
            return false; // They are not symmetric, so return false
        }
        // End of if block

        if (left.val != right.val) {
            // If the values of the current nodes differ
            return false; // The subtrees cannot be mirror images, so return false
        }
        // End of if block

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        // Recursively compare the opposite children
    }
    // End of isMirror method

}
// End of Solution class

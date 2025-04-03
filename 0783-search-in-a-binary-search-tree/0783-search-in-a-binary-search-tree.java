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
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
      // If root is null, or we've found the value
        if (root == null || root.val == val) {
            return root;
        }
        
        // If val is less than the root's value, search the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        
        // If val is greater than the root's value, search the right subtree
        return searchBST(root.right, val);
    }
}
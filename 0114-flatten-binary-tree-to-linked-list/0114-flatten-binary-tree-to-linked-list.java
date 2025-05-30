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

//class for the tree node -- val, left ptr, right ptr, 

//input - node thats going to be the root of the tree

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store left and right subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;

        // Set left to null and move left subtree to right
        root.left = null;
        root.right = left;

        // Traverse to the end of the new right subtree and attach original right
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
    }
}

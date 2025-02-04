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

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {

        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

         diameter = Math.max(diameter, left + right);
        

        //finding the height at each node and return this so it can be recalled for the next node
        return Math.max(left, right) + 1;
    }
}
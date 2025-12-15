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

    path -- cant reverse dirctions -- just one direction the entire way through


    when it comes to access value 
        pre-order
        level-order
        post-order -- would work best - go all the way down before accessing value -- maximize the path im accessing
                        guarentees chjildren to be access first


        when i do access each node
            left child gain - dfs from there to find the max path -- comparisoin functio
            right child gain - dfs from there 

        from the aprents i am at, find the max with the left child gain and the right child gain - 


 * }
 */
class Solution {

    private int maxSum; //global variable

    public Solution() {
        this.maxSum = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        //base
        if (node == null) {
            return 0; 
        }

        int leftChildGain = Math.max(0, dfs(node.left));
        int rightChildGain = Math.max(0, dfs(node.right));
        
        int priceNewPath = node.val + leftChildGain + rightChildGain;

        maxSum = Math.max(maxSum, priceNewPath);

        return node.val + Math.max(leftChildGain, rightChildGain);
        
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        //create a queue
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        //check if the root is null and end it
        if(root == null) return res;

        q.add(root);

        while(!q.isEmpty()) {

            int amt = q.size();

            //make one list for just the values on a specific level
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < amt; i++) {

                if(q.peek().left != null) {
                
                    q.add(q.peek().left);
                }

                if(q.peek().right != null) {
                    q.add(q.peek().right);
                }

                curr.add(q.remove().val);

            }

            res.add(curr);


        }

        return res;

        
    }
}
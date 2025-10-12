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

/**

DFS

if the nodes are NOT NULL
    create a new node with the sum, merge it into the rtree - merge it recrusively 

At least one node is NULL
    return what was already there -- recloning sub tree


 */


class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        //i dont actually change the inputs
        return mergeAndDuplicate(root1, root2);
    }

    // recursively merge the trees into one tree
    private TreeNode mergeAndDuplicate(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null) return null;
        if(t1 == null) return cloning(t2);
        if(t2 == null) return cloning(t1);
        
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeAndDuplicate(t1.left, t2.left);
        merged.right = mergeAndDuplicate(t1.right, t2.right);
        return merged;
    }

    private TreeNode cloning(TreeNode node) {
        if (node == null) return null;
        TreeNode copy = new TreeNode(node.val);
        copy.left = cloning(node.left);
        copy.right = cloning(node.right);
        return copy;
    }
}
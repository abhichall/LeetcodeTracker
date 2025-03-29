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
     int pI = 0;

        //hmap to store index + value
        HashMap<Integer, Integer> hmap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //index of preorder 
       

        //hmap to store index + value
        for(int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);

    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right) return null;

        int rootVal = preorder[pI++];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = hmap.get(rootVal);

        root.left = build(preorder, left, rootIndex - 1);

        root.right = build(preorder, rootIndex + 1, right);

        return root;
    }
}
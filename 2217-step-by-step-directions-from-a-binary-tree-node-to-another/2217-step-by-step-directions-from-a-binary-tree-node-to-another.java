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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Paths from ROOT to each target (sequence of 'L'/'R')
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest  = new StringBuilder();

        // DFS builds path by backtracking; returns true when found
        getPath(root, startValue, pathToStart);
        getPath(root, destValue,  pathToDest);

        String s = pathToStart.toString();
        String d = pathToDest.toString();

        // Find length of common prefix (path to LCA)
        int i = 0, m = s.length(), n = d.length();
        while (i < m && i < n && s.charAt(i) == d.charAt(i)) i++;

        // Steps: up from start to LCA, then down along dest suffix
        StringBuilder ans = new StringBuilder();
        for (int k = i; k < m; k++) ans.append('U');   // go up from start to LCA
        ans.append(d.substring(i));                    // then follow L/R down to dest
        return ans.toString();
    }

    // Build path from root to target as 'L'/'R' using DFS backtracking.
    // path is mutated in-place; if target not here, backtrack the last move.
    private boolean getPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) return false;
        if (node.val == target) return true;

        path.append('L');
        if (getPath(node.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (getPath(node.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}

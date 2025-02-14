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

    int count = 0;    // Initialize the visited nodes counter to zero
    int result = 0;   // Initialize the result variable to zero
    
    public int kthSmallest(TreeNode root, int k) {
    // Method to return the kth smallest element in the BST
    

    inorder(root, k); // Start in-order traversal from the root node with the target k

    return result;    // Return the kth smallest value found
}

// End of kthSmallest method

private void inorder(TreeNode node, int k) {
    // Recursive helper method for in-order traversal
    if (node == null) {
        // Check if the current node is null
        return; // Exit the function as there is nothing to process
    }

    if (count == k) {
        // Check if the kth smallest element has already been found
        return; // Exit early to avoid unnecessary traversal
    }

    inorder(node.left, k); // Recursively traverse the left subtree

    if (count == k) {
        // Check again if the kth element has been identified after left subtree traversal
        return; // Exit early if the kth smallest element is already found
    }

    count++; // Increment the counter as the current node is being visited

    if (count == k) {
        // Check if the current node is the kth visited node
        result = node.val; // Record its value as the kth smallest element
        return; // Exit early since the kth smallest value has been obtained
    }

    inorder(node.right, k); // Recursively traverse the right subtree
}

// End of inorder helper method
}
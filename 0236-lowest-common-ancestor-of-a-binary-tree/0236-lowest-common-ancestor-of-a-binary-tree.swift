/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */

class Solution {
    func lowestCommonAncestor(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
        //edge case
        guard let node = root else {return nil}
        if node === p || node === q {
            return node
        }

        //search the left subtree for p or q
        let leftResult = lowestCommonAncestor(node.left, p, q)
        //search the right subtree for p or q
        let rightResult = lowestCommonAncestor(node.right, p, q)

        //if both result in non nil , then the current node is the lca
        if leftResult != nil && rightResult != nil {
            return node
        }

        return leftResult ?? rightResult


        
    }
}


/*


LCA - lowest in the tree that has p and q and descendents 

dfs -- return nil, p, q, lcaw

*/
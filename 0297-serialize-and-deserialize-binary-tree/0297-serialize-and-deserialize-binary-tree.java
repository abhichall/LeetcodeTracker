/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL = "null";
    private static final String SEP = ",";

    // Serialize using preorder traversal
    public String serialize(TreeNode root) {
        if (root == null) return NULL + SEP;
        return root.val + SEP + serialize(root.left) + serialize(root.right);
    }

    // Deserialize using a queue to rebuild recursively
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return build(nodes);
    }

    private TreeNode build(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(nodes);
        node.right = build(nodes);
        return node;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
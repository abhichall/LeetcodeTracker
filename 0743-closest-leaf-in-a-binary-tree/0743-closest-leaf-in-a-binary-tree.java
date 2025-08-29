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
    public int findClosestLeaf(TreeNode root, int k) {

        if(root.left == null && root.right == null) return root.val;

        //STEP 1 -- build graph
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        // STEP 2 -- find target node with dfs
        TreeNode targetNode = findTarget(root, k);

        //STEP 3 -- BFS to find the closest leaf
        int result = bfs(targetNode, graph);

        return result;
    }

// Build undirected graph: parent <-> child
    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;

        graph.putIfAbsent(node, new ArrayList<>());
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    // Find the node with value k
    private TreeNode findTarget(TreeNode root, int k) {
        if (root == null) return null;
        if (root.val == k) return root;
        TreeNode left = findTarget(root.left, k);
        if (left != null) return left;
        return findTarget(root.right, k);
    }

    // BFS from target until we hit a leaf
    private int bfs(TreeNode start, Map<TreeNode, List<TreeNode>> graph) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // If it's a leaf in the original tree → answer
            if (node.left == null && node.right == null) {
                return node.val;
            }

            for (TreeNode nei : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.offer(nei);
                }
            }
        }
        return -1; // should not happen
    }
}



/**

we want to return the nearest leak node to a target
    lead node -- is one that has no children

    we have to move upward -- when we do traversla we should treat this as an undirected graph

    STEP 1 - build adj list; allows us to traverse up
    build an adj - undirected -- us this to build our graph

    STEP 2 - DFS to find target node -- every node might need to be visited

    STEP 3 - BFS to find the closest lead node; since bfs used to find shortest; we can j check every child


BFS and DFS

 DFS -- we could go through 


 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget (int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);

        dfs(0, graph, curr, result);

        return result;

    }

    private void dfs(int node, int[][] graph, List<Integer> curr, List<List<Integer>> result) {

        //if we reached target node
        if(node == graph.length - 1) {
            result.add(new ArrayList<>(curr));
            return;
        }

        //visit the neighbors
        for (int adj : graph[node]) {
            curr.add(adj);
            dfs(adj, graph, curr, result);
            curr.remove(curr.size() - 1);
        }

    }
}
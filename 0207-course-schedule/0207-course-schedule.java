class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] visited = new int[numCourses]; // 0 = not visited, 1 = visiting, 2 = fully processed

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the graph (prerequisite → course)
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adjList.get(prereq).add(course);
        }

        // Check for cycles in each course
        for (int i = 0; i < numCourses; i++) {
            if (cycleCheck(i, adjList, visited)) {
                return false; // Cycle detected
            }
        }

        return true; // No cycles, can finish all courses
    }

    private boolean cycleCheck(int course, List<List<Integer>> adjList, int[] visited) {
        if (visited[course] == 1) return true; // Cycle detected
        if (visited[course] == 2) return false; // Already fully processed (no cycle from this node)

        // Mark as visiting (in recursion stack)
        visited[course] = 1;

        // Check all dependent courses
        for (int next : adjList.get(course)) {
            if (cycleCheck(next, adjList, visited)) {
                return true;
            }
        }

        // Mark as fully processed (no cycles found from this node)
        visited[course] = 2;
        return false;
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] visited = new int[numCourses]; // 0 = not visited, 1 = visiting, 2 = fully processed
        List<Integer> courseOrder = new ArrayList<>();
        
        // Step 1: Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Build the graph (prerequisite → course)
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adjList.get(prereq).add(course);
        }

        // Step 3: Check for cycles and generate order
        for (int i = 0; i < numCourses; i++) {
            if (cycleCheck(i, adjList, visited, courseOrder)) {
                return new int[0]; // Cycle detected, return empty array
            }
        }

        // Step 4: Reverse the order since DFS processes in postorder
        Collections.reverse(courseOrder);

        // Convert list to array
        return courseOrder.stream().mapToInt(i -> i).toArray();
    }

    private boolean cycleCheck(int course, List<List<Integer>> adjList, int[] visited, List<Integer> courseOrder) {
        if (visited[course] == 1) return true; // Cycle detected
        if (visited[course] == 2) return false; // Already processed, skip

        // Mark as visiting (in recursion stack)
        visited[course] = 1;

        // Check all dependent courses
        for (int next : adjList.get(course)) {
            if (cycleCheck(next, adjList, visited, courseOrder)) {
                return true;
            }
        }

        // Mark as fully processed
        visited[course] = 2;
        courseOrder.add(course); // Add course to order in postorder

        return false;
    }
}

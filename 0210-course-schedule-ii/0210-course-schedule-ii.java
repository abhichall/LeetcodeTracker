
public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Define the findOrder method with numCourses and prerequisites as parameters

        List<List<Integer>> graph = new ArrayList<>();
        // Create an adjacency list to represent the course dependency graph

        for (int i = 0; i < numCourses; i++) {
            // Loop over each course to initialize the graph
            graph.add(new ArrayList<>());
            // Add an empty list for each course
        }
        // End of for loop to initialize graph

        int[] indegree = new int[numCourses];
        // Create an array to store the number of prerequisites (indegree) for each course

        for (int[] pre : prerequisites) {
            // Iterate over each prerequisite pair
            int course = pre[0];
            // The course that depends on the prerequisite
            int prerequisite = pre[1];
            // The prerequisite course that must be taken first

            graph.get(prerequisite).add(course);
            // Add an edge from the prerequisite to the course
            indegree[course]++;
            // Increment the indegree for the course
        }
        // End of for loop for prerequisites

        Queue<Integer> queue = new LinkedList<>();
        // Initialize a queue to perform a BFS for the topological sort

        for (int i = 0; i < numCourses; i++) {
            // Loop over all courses to find those with no prerequisites
            if (indegree[i] == 0) {
                // If the course has no prerequisites
                queue.offer(i);
                // Add the course to the BFS queue
            }
            // End of if condition
        }
        // End of for loop to populate initial queue

        int[] order = new int[numCourses];
        // Create an array to store the valid ordering of courses
        int index = 0;
        // Initialize an index variable for the order array

        while (!queue.isEmpty()) {
            // Continue processing while there are courses in the queue
            int curr = queue.poll();
            // Remove a course from the front of the queue
            order[index++] = curr;
            // Add the removed course to the order array and increment the index

            for (int neighbor : graph.get(curr)) {
                // Iterate over all courses that depend on the current course
                indegree[neighbor]--;
                // Decrement the indegree of the dependent course since one prerequisite is now satisfied

                if (indegree[neighbor] == 0) {
                    // If the dependent course has no remaining prerequisites
                    queue.offer(neighbor);
                    // Add it to the queue to be processed next
                }
                // End of if condition for neighbor
            }
            // End of for loop for processing all neighbors
        }
        // End of while loop for BFS traversal

        if (index == numCourses) {
            // If all courses have been processed
            return order;
            // Return the computed valid order of courses
        } else {
            // If not all courses were processed, a cycle must exist
            return new int[0];
            // Return an empty array indicating it's impossible to complete all courses
        }
        // End of conditional check
    }
    // End of findOrder method
}
// End of Solution class

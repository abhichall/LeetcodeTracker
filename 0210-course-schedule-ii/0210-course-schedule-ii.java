class Solution {

    /*

    pair[0,1] -- means first 1 and then 0 -- or else not possible

    relationships

    1 - 0
    2 - 0
    3 - 1, 2

    Adjacency list
    [a, b] -> b -> a

    find the number of courses that are required for a specific course - order of nec

    courses with. 0 reqs take first, and then go on from there

    adj list built - calculated in-degree (how many are needed) (in degree represents how many prereqs for each)

    add everything with a indegree 0 -- queue -- add to result & decrease by 1 the indegree of the neighbors 
        if any neighbor then has 0 indegree, than add to result

    Kahn's Algorithm

    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //base case
        if(numCourses <= 0) return new int[0];

        //make the adjacency list representations of graph
        List<Integer>[] graph = new ArrayList[numCourses]; // populates with amount

        //iterate through # of course
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>(); //populate with array list to edit later
        }

        //calculate the indegree for each course -- hold it in array
        int[] indegree = new int[numCourses];

        //build graph WITH the indegree 
        for(int[] p : prerequisites) {

            //p[0] -- is course ; p[1] is the prerequisite -- p[1] -> p[0]
            int course = p[0];
            int preReq = p[1];

            //add to the adj list
            graph[preReq].add(course);
            indegree[course]++; //leeps track of how many pre req needed

        }   //at this point, entire adj list, and indegree array populated

        //queue to find order
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        } //end of this have eveyrhitng that has NO prerequisites before it

        int[] resultOrder = new int[numCourses];
        int index = 0;

        //process bfs
        while(!q.isEmpty()) {

            int curr = q.poll();
            resultOrder[index++] = curr;

            //decrease the indegree of neighbors
            for(int neighbor : graph[curr]) {
                indegree[neighbor]--;

                //check if no more preqs for that neighbor
                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        //by this point, have all courses in order
        //double chcek
        if(index == numCourses) {
            return resultOrder;
        } else {
            return new int[]{};
        }


        
    }
}
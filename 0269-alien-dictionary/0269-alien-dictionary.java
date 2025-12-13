class Solution {
    public String alienOrder(String[] words) {

        //edge case 
        if (words.length == 0 || words == null) return "";

        //adj list - for each char - set of chars after it
        Map<Character, Set<Character>> graph = new HashMap<>();
        //indegree
        int[] indegree = new int [26];
        //know which chars are actually present in words
        boolean[] present = new boolean[26];

        //initialize present chars in given words
        for (String w: words) {
            for (char c: w.toCharArray()) {
                present[c - 'a'] = true;
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        //build edges + compare words
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i+1];

            //if first longer than second and second is prefix of first
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            int minLength = Math.min(first.length(), second.length());

            //find first different character 
            for (int k = 0; k < minLength; k++) {
                char c1 = first.charAt(k);
                char c2 = second.charAt(k);

                if (c1 != c2) {
                    Set<Character> neigh = graph.get(c1);
                    if (!neigh.contains(c2)) {
                        neigh.add(c2);
                        indegree[c2 - 'a']++;
                    }

                    break;
                }
            }
        }

        //kahns algo - iterating from indegree 0, and making way acros
        Queue<Character> q = new ArrayDeque<>();
        int total = 0;
        for (int i =0; i < 26; i++) {
            if (present[i]) {
                total++;
                char c = (char) ('a' + i);

                if (indegree[i] == 0) {
                    q.offer(c);
                }
            }
        }


        //build answer
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);

            for (char n : graph.getOrDefault(curr, Collections.emptySet())) {
                indegree[n - 'a']--;

                if (indegree[n - 'a'] == 0) {
                    q.offer(n);
                }
            }
         }

         //if all present characrters are include
         if (sb.length() == total) {
            return sb.toString();
         }
    
    return "";
        
    }
}


/**

sorted lexographically -- whichever appears in the dictionary works


output -- string of unique letters  sorted lexig. by increasing order


ideas
    representing as a directed graph -- compare characters within each word
    adjacency list - indegrees - traverse starting indegree 0 
    using sort -- topological sort - continue to choose indegree of 0


    3
    - creating adj list
    - topological sort - kahns algorith
    - build the sb and return depening on the constraints

 */
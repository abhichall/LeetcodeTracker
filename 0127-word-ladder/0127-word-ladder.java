class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //for O(1) lookup - hashset
        Set<String> wordSet = new HashSet<>(wordList);

        //to keep track of what we already checked 
         Set<String> visited = new HashSet<>();
        
        //edge cases
        if(!wordSet.contains(endWord)) return 0;

        //initialize bfs
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int changes = 1;

        //bfs
        while(!q.isEmpty()) {
            
            int size = q.size(); //keep level by lever

            for(int i = 0; i < size; i++) { //iterate through each word in given level

                    String curr = q.poll();

                    //change each char
                    for(int j = 0; j < curr.length(); j++) {
                        char[] word = curr.toCharArray();

                        for( char c = 'a'; c <= 'z'; c++) {

                        //change being made                            
                        word[j] = c;

                        //need to check if its same now so
                        String postChange = new String(word);

                        //if it is now the end word, we finished it
                        if(postChange.equals(endWord)) {
                            return changes + 1;
                        }

                        //if its not, then we have to account for it being visitied and move on
                        if(wordSet.contains(postChange) && !visited.contains(postChange)) {
                            q.offer(postChange);
                            visited.add(postChange);
                        }

                }
        }
                
           
            }
                 changes++;
            

        }
       
        return 0;
        
    }
}

 // wordList - contains a dictionary of sorts that has words that we have
        //have to find the shortest number of transformatinons from begin to endword
        //return 0 if not possible

        //edge case - is it possible for wordlist to just be empty, or any of them
            //check if endword is in wordlist - return 0 if not
            //check if begin word is same as end word -return 1

        // bfs approach - goes to neighbor or next one at a time
            //can treat words as the nodes and transformations as edges
                //bfs will look at all possible transformations one by one

            //to implement bfs - use queue, storing words + number of transformations
                    //keep track of visied nodes
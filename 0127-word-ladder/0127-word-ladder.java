class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //this will keep track - allow for ez search + access
        //initialize this w pre populating the hashset with the word list
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return 0;

        //queue for bfs
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 1;

        //pretty much bfs to check everything
       while (!q.isEmpty()) {
            int levelSize = q.size(); // Number of words at the current BFS level

            for (int i = 0; i < levelSize; i++) {
                String currWord = q.poll();
                if (currWord.equals(endWord)) return count;

                // Try all possible one-letter transformations
                char[] wordArr = currWord.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char origChar = wordArr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (wordArr[j] == c) continue; // Skip same letter replacement

                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        // If the new word exists in the dictionary, add to queue
                        if (wordSet.contains(newWord)) {
                            q.add(newWord);
                            wordSet.remove(newWord); // Mark as visited
                        }
                    }
                    wordArr[j] = origChar; // Restore original letter
                }
            }
            count++; // Increase level count after processing current level
        }
        return 0; // No valid transformation sequence found
    }
}
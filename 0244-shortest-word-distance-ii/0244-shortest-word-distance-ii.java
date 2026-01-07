class WordDistance {

    Map<String, List<Integer>> hmap = new HashMap<>();

    public WordDistance(String[] wordsDict) {
    
        // iterates array, populates hashmap with word as key, and index of occurences as value
        for (int i = 0; i < wordsDict.length; i++) {
            hmap.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }

    }
    
    public int shortest(String word1, String word2) {

        //populate into these variables the list of indexes where words occurs
        List<Integer> l1 = hmap.get(word1);
        List<Integer> l2 = hmap.get(word2);

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE; //global tracker

        while (i < l1.size() && j < l2.size()) {

            int index1 = l1.get(i);
            int index2 = l2.get(j);

            min = Math.min(min, Math.abs(index1 - index2));

            if (index1 < index2) i++; else j++;

        }

        return min;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */

 /**
 
 to design a class that stores the positions of each work
 return the shortest disance between any two given words

    preprocess all of the words in the array once
    have a hashmap that stores the key as the word -- the value a list of all the index where the word appears
    
    use the hashamp to get the two index lists, two pointers to iterate those 
  
  ['practice', 'makes', 'perfect, 'coding', 'makes']

  HMAP --

  (practice, 0)
  (makes, 1,4)
  perfect(2)
  coding (3)

query(coding, practice) -- coding - 3 practice - 0
            dist = 3

query(makes, coding) -- [1,4] [3]
    global min tracker - min -- 1


   */
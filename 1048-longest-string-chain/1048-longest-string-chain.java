class Solution {
    public int longestStrChain(String[] words) {

        //edge case
        if (words == null || words.length == 0) return 0;

        //sort by length
        Arrays.sort(words, Comparator.comparingInt(String::length)); 

        //dp map
        Map<String, Integer> dp = new HashMap<>();
        int max = 1; //has to be at least

        for (String word: words) {
            int best = 1; // min length

            for (int i = 0; i < word.length(); i++) {
                String pred = word.substring(0,i) + word.substring(i+1);

                //if pred exists alr, ++
                Integer prevChain = dp.get(pred);
                if (prevChain != null) {
                    best = Math.max(best, prevChain + 1);
                }
            }

            dp.put(word, best);

           max = Math.max(max, best);
        }

    return max;
        
    }
}

/**

A is a PREDECESSOR of B, only if, exactly one letter can be inserted into A without changing the order of the other characters to make it equal to B

word chain - sequence of words [w1, w2, w3] - where w1 is a predecessor of w2, w2 of w3 and so on

return length of longest possible word chain - as an array

ideas
    we know that it has to be short to long

    sort words by length
    dp approach where in a hmap, i can store a word --> longest chain length that ends in that word (build upon prev)
    for each word, i could look at the hmap corresponding value and then update the count calculation





 */
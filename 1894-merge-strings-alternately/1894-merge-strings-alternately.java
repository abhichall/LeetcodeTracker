class Solution {
    public String mergeAlternately(String word1, String word2) {

        //stringbuilder since we are going to append a lot
        StringBuilder name = new StringBuilder();

        //only one pointer is necessary as the same positions will be appended from each word
        int j = 0;

        while ( j < word1.length() || j < word2.length()) {

            if (j < word1.length()) {
                name.append(word1.charAt(j));
            }

            if (j < word2.length()) {
                name.append(word2.charAt(j));
            }
        
        j++;

        }
    
        //converts to a string
        return name.toString();
     
        }

    }

class Solution {
    public int longestPalindrome(String[] words) {

        //find the longest palandirome by concataniing two letter words from a given array
        //ALL WORDS ARE TWO LETTERED'

        //RUN THRU TC

        // IDEAS
            // try to find all combinations of the words -- multiple times iterating thru and having logic statements -- but this would O expponential -- too much reiteration
 
    
            // palindormes have properties - specific for these 2 letters - 1) one odd character in middle; 2) pairs have to be mirrors of each otehr or reverse; 3)same letters can be used and treated as one
                // with thwo letter words -- it needs kinda be reverses of eachother

         // hashmap -- count frequencies of each word
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        //variables 
        int result = 0;
        boolean hasCenter = false;

        // now go through all the words and their corresponding frequencies
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            
            String word = entry.getKey();
            int occ = entry.getValue();

            //need to find reverse by palindrome def
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.charAt(0) == word.charAt(1)) {
                // Case: same letters (like "aa")
                //every pair contributes 4 to length so do 
                result = result + ((occ / 2 ) * 4); 

                if (occ % 2 == 1) { // this means theres an extra double repeating char, so then we can j put it in the middle
                    hasCenter = true;
                }

            } else if (word.compareTo(reversed) < 0 && freq.containsKey(reversed)) {
                // Case: mirrored pairs ("ab" with "ba"), but avoid double counting
                result += Math.min(occ, freq.get(reversed)) * 4; //its times 4 since palindromes come together w length of 4
            }
        }

            if (hasCenter) {
                result += 2; // this is just the odd one out and has length of 2 
            }

            return result;
        }
    }

    
        //iterate though each word with its frequency -- pull from hmap

                // Case 1 - when the words have a frequency of 2, can go on either side of ONE letter. each pair can account for a length of 4

                // Case 2 - when the frquency is odd
        
    
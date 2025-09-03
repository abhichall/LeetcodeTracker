class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        //have a list of strings to store final answer
        List<String> res = new ArrayList<>();

        //ptr to track where we are in words array
        int i = 0;

        //iterate
        while( i < words.length) {

            //put AS MANY words as possible in the first line
            int length = words[i].length();

            //ptr looking at next words
            int j = i + 1;
            
            while ( j < words.length && (length + words[j].length() + 1) <= maxWidth) { //+1 to account for at least 1 space
                length = length + words[j].length() + 1; //account for space too
                j++; //keep adding words till not possible
            }

            //at this point, we will have the max words possible that we can put on one line without crossing maxWidth
                //from index i to j - 1

            StringBuilder line = new StringBuilder();
            int numWords = j - i;

            //appending state with spaces

            //special case - if this is the last line or if there is only one word
            if (j == words.length || numWords == 1) {

                //add the words with just one space -- have to do left justifying
                for(int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                    }
                }
                //we know now that we will need to pad 
                while(line.length() < maxWidth) {
                    line.append(" ");
                }

            } else { //now we are dealing with every other line

                int totalSpaces = maxWidth - wordLength(words, i, j); //gets the number of spaces needed to account for maxwidth 
                int gaps = numWords - 1;          //finds the number of at least one spaces we need between the words

                int spacesPerGap = totalSpaces/gaps; //gives us way to even it out
                int padding = totalSpaces % gaps; //leftovers to padd and even up

                for(int k = i; k < j; k++) {

                    line.append(words[k]);

                    //add space after each words
                    if( k < j - 1) {
                        
                        for(int s = 0; s < spacesPerGap; s++) {
                            line.append(" ");
                        }

                        if(padding > 0) {
                            line.append(" ");
                            padding--;
                        }
                    }
                }
            }
                res.add(line.toString());
                i = j; // move on from where we left off same logic
        
        }

        return res; 
    }

    private int wordLength(String[] words, int start, int end) {
        int l = 0;

        for(int i = start; i < end; i++) {
            l = l + words[i].length();
     }
     return l;
    }
}


/**


what does it mean to be left and right justified -- it j means that the left and right side is straight vertical line


input -- array of words, int maxwidth

output -- list of strings that has maxWidth characters and is lined up on left n right

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16

Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

CLARIFICATION:
do spaces count as a character?
what if a single word has more than the def maxwidth of characters


IDEAS:
    count all the characters within the given array
    divide by length of array, and based on that we could print on a specifc line, filling in parts with spaces 
    many reiterations - not optimal/dirty and bulky code


    GREEDY APPROACH

    fit the max words on a line <= maxWidth
        at least 1 space between each word - counter++

    iterate till we read max width on a line
    strinbuilder - spaces

    if we are on the last line or only one word fits -- add words with one space -- left justify (right spaces)

    if on any other line 
        totalSpaces = maxWidth - length of the the words only  -- there needs to be ____ spaces in total
        gaps = number of words - 1
        spaces per gap = totalspaces / gaps
        leftover spaces that would be uneven -- total spaces % gaps


    append to sb
    move on to next set of words/new line



 */
class Solution {
    public boolean equalFrequency(String word) {

        //if the word is just one letter - t
            //create an arr of 26 - use ascii values to store freq of each 

            int[] charOcc = new int[26];
            for(char c: word.toCharArray()) {
                charOcc[c - 'a']++; //populate array with each letter's frequency
            }      

            //iterate
            for (int i = 0; i < 26; i++) {
                
                //if occ is 0, theres no point in dealing
                if(charOcc[i] == 0) continue;

                charOcc[i]--;

                if(checkEqual(charOcc)) {
                    return true;
                }
                charOcc[i]++;
            }

            return false;

        
    }

    private boolean checkEqual(int[] charOcc) {
        int counter = 0;

        //find the first number in array that isnt 0
        //will check rest to see if ALL are eqaul
        for (int occ: charOcc) {
            if (occ > 0) {
                counter = occ;
                break;
            }
        }

        //check if rest are equal
        for(int occ: charOcc) {
            if (occ > 0 && occ != counter) {
                return false; 
            }
        }
        return true; 
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {

        //hashset
        Set<Integer> hset = new HashSet<>();

        //adds each number to a hashset
        //since duplicates dont matter, hset is best
        for (int n : nums) {
            hset.add(n);
        }
        
        //helps keep track
        int maxSeq = 0;

        // Changed to iterate through HashSet instead of array
        for (int currValue : hset) {
            
            //always start at 1
            int currSeq = 1;

            //f hset contains value less than currVal then it isnt consecutive
            if (hset.contains(currValue - 1)) {
                continue;
            }

            //start cons. seq
            if (hset.contains(currValue + 1)) {
                currSeq++;
                currValue++;

                    //continues to add on
                    while(hset.contains(currValue + 1)) {
                        currSeq++;
                        currValue++;
                    }
            }

            //keep track of max
            maxSeq = Math.max(currSeq, maxSeq);
        }

        return maxSeq;
    }
}
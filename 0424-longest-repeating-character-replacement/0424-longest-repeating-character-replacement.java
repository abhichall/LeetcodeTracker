class Solution {
    public int characterReplacement(String s, int k) {

        //trying to find the longest substring that will be able to have the same characters after the max k changes

        //if we have the frequency of each letter, then we will be able to know how much changes needed in a given window
            //and can compare tht to k

        //can keep track of characters here
        int[] freq = new int[26];
        int maxFreq = 0;

        //to know the size of the windown - right most - left most +1
        int left = 0;

        //var for max size
        int size = 0;

        for(int right = 0; right < s.length(); right++) {

            //input freq amt
            freq[s.charAt(right) - 'A']++;
             maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            if( ((right-left) + 1) - maxFreq > k) { //this means that the window is too big for only k changes
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            size = Math.max(size, right-left+1);
        }
return size;
        
    }
}
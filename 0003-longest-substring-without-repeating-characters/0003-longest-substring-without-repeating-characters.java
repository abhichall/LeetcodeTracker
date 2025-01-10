class Solution {
    public int lengthOfLongestSubstring(String s) {

        //hashet to hold substring
        Set<Character> hset = new HashSet<>();

        int max = 0;
        int left = 0;
        int counter = 0;

        for (int right = 0; right < s.length(); right++) {

            if(!hset.contains(s.charAt(right))) {
                hset.add(s.charAt(right));
                max = Math.max(max, (right - left) + 1);
            }  else if(hset.contains(s.charAt(right))) {
                
                while(hset.contains(s.charAt(right))) {
                    hset.remove(s.charAt(left));
                    left++;
            }
            hset.add(s.charAt(right));
        }
        }
        
        return max;
    }
}
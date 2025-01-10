class Solution {
    public boolean isAnagram(String s, String t) {

        //base case
        if (s.length() != t.length()) {
            return false;
        }

        //arr to keep track of letter occurences
        int[] occ = new int[26];

        //this for loop goes through all length of input strings so - O(N)
        for (int i = 0; i < s.length(); i++) {
            occ[s.charAt(i) - 'a']++;
            occ[t.charAt(i) - 'a']--;
        }

        //goes through fixed number of index array - O(1)
        for (int n : occ) {
            if (n != 0) {
                return false;
            }
        }

        return true;
        
    }
}
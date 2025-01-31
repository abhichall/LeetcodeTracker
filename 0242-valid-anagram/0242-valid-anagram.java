class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] occ = new int[26];

        for (int i = 0; i < s.length(); i++) {

            occ[s.charAt(i) - 'a']++;
            occ[t.charAt(i) - 'a']--;

        }

        for(int n : occ) {
            
            if (n != 0) return false;
        }
        return true;
    }
}
class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) {
            return true;
        }

        int j = 0;
        int k = 0;

        while (j < s.length() && k < t.length()) {

            if (s.charAt(j) == t.charAt(k)) {
                j++;
            }

            k++;

        }

        if (j != s.length()) {
            return false;
        }

        return true;
        
    }
}

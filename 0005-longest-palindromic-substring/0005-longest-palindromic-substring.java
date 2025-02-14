class Solution {
    public String longestPalindrome(String s) {

        //edge cases
        if (s == null || s.length() == 0) return "";

        int start = 0; //keeps track of the starting index of the longest palindrome so far
        int maxLen = 0; //stores length of the longest palindrom found so far


        //palindromes expand from center
        
        for(int i = 0; i < s.length(); i++) {
            
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }

            //for even length palindrome
            left = i;
            right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                 if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
         }


        return s.substring(start, start + maxLen);

        
        
    }
}
class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;
        if (x==1) return true;

        String s = Integer.toString(x);

        int j = 0;
        int k = s.length() - 1;

        while (j < k) {
            if (s.charAt(j) != s.charAt(k)) {
                return false;
            }

            j++;
            k--;
        }

        return true;
        
    }
}
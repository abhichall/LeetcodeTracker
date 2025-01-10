class Solution {
    public boolean isPalindrome(String s) {


        s  = s.toLowerCase();

        int j = 0;
        int k = s.length() - 1;


        while (j < k) {

            char left = s.charAt(j);
            char right = s.charAt(k);

            if (!Character.isLetterOrDigit(left)) {
                j++;
                continue;
            }
       
            if (!Character.isLetterOrDigit(right)) {
                k--;
                continue;
            }

            if (left != right) {
                return false;
            }

            j++;
            k--;
       
        }

        return true;

        
    }
}
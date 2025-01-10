class Solution {
    public void reverseString(char[] s) {

        int j = 0;

        int k = s.length - 1;

        while(j < k) {

            char val1 = s[j];
            char val2 = s[k];
            
            s[j] = val2;
            s[k] = val1;

            j++;
            k--;

        }

    }
}
class Solution {
    public int maxVowels(String s, int k) {

        //counter 
        int counter = 0;

        //for loop to find number of vowels in first k
        for (int i = 0; i < k; i++){
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                counter++;
            }
        }

        int maxAmount = counter;

        //Sliding window Algorithm
        int left = 0;
        int right = k;

        while (right < s.length()) {

            if (s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' || s.charAt(left) == 'o' || s.charAt(left) == 'u') {
                counter--;
               
            }

            if (s.charAt(right) == 'a' || s.charAt(right) == 'e' || s.charAt(right) == 'i' || s.charAt(right) == 'o' || s.charAt(right) == 'u') {
                counter++;
               
            }

            maxAmount = Math.max(counter, maxAmount);
          

            //change window
            left++;
            right++;
        }
        return maxAmount;
    }
}
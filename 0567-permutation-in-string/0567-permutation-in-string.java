class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;

        //keep track of frequency within size of s1 window
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        //now if the arrays are equal then true
        if(Arrays.equals(s1Count, s2Count)) return true;

        for(int i = s1.length(); i < s2.length(); i++) {

            //add this value
            s2Count[s2.charAt(i) - 'a']++;

            //remove first val
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            if(Arrays.equals(s1Count, s2Count)) return true;



        }

     return false;   
    }
}
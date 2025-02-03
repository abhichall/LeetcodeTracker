class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //make a array of char occ
        //slide it through longer one
        //if equal, then the return true

        int[] s1occ = new int[26];
        int[] s2occ = new int[26];
        

        //edge cases
        if (s1.length() > s2.length()) return false;

        for(int i = 0; i < s1.length(); i++) {
            s1occ[s1.charAt(i) - 'a']++;
            s2occ[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1occ, s2occ)) return true;

        
        for(int i = s1.length(); i < s2.length(); i++) {

            s2occ[s2.charAt(i) - 'a']++;
            
            s2occ[s2.charAt(i - s1.length()) - 'a']--;

        
            if(Arrays.equals(s1occ, s2occ)) return true;

        }


        return false;

        
    }
}
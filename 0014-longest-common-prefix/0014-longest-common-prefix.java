class Solution {
    public String longestCommonPrefix(String[] strs) {


        //edge case
        if (strs == null || strs.length == 0) return "";

        //to keep it consistent -- smallest word to larges
        Arrays.sort(strs);

        //will hold the value of the first stirng in the array of strings
        String first = strs[0];
        //holding the last string
        String last = strs[strs.length - 1];

        int i = 0; //to iteratite
        
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }
}

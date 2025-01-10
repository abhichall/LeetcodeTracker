class Solution {
    public String reverseWords(String s) {
    
    //this will trim whitespaces, and then split into substring array split by every spaced
    String[] stringy = s.trim().split("\\s+");

    String output = "";

    for (int i = stringy.length - 1; i >=0; i--) {
        output = output + stringy[i] + " " ;
    }



return output.trim();


    }
}
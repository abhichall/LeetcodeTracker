class Solution {
    public int leastInterval(char[] tasks, int n) {

        //keep track of frequencies
        int[] occ = new int[26];


        //count and store each freq
        for(char c: tasks) {
            occ[c - 'A']++;
        }
        

        //sort to find the max
        Arrays.sort(occ);
        int max = occ[25];


        int count = 1; // since theres already 1 max

        for(int i = 24; i >= 0; i--) {
            
            if(occ[i] == max) {
                count++;
            } else {
                break; //since its sorted, means theres no more that are more 
            }
        }

        int min = (max - 1) * (n + 1) + count;

        return Math.max(min, tasks.length);

    }
}
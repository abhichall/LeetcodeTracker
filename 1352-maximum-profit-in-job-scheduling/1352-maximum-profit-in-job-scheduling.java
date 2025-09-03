class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        //edge cases
        if(startTime == null || endTime == null || profit == null) return 0;

        int n = startTime.length;
        
        //STEP 1 - create tuples [startTime, endTime, profit]
        int[][] all = new int[n][3];
        for(int i = 0; i < n; i++) {
            all[i][0] = startTime[i];
            all[i][1] = endTime[i];
            all[i][2] = profit[i];
        }
        
        //STEP 2 - sort by endTimes
        Arrays.sort(all, Comparator.comparingInt(a -> a[1]));

        //create a new array just for the end times -- fast binary search
        int[] ends = new int[n];
        for(int i = 0; i < n; i++) {
            ends[i] = all[i][1];
        }

        //STEP 3 - array to store all the max profit until the ith point
        int[] maxUntil = new int[n];

        //populating the maxUntil array
        for (int i = 0; i < n; i++) {
            int currStart = all[i][0];
            int currEnd = all[i][1];
            int currProf = all[i][2];

            //STEP 4 - find the job that ends before curr starts -- binary search
            int j = nonOverlapping(ends, currStart);

                //take current job
                int take = currProf + (j >= 0 ? maxUntil[j] : 0);

                //skip current job
                int skip = (i > 0 ? maxUntil[i-1] : 0);

                //desipte, we want to see which situation yields MOST profit
                maxUntil[i] = Math.max(take, skip);
        }
    
        return maxUntil[n-1];
        
    }


    //binary search to find the non overalpping jobs
    private int nonOverlapping(int[] ends, int target) {
        int low = 0;
        int high = ends.length - 1;
        int ans = -1; //fall back

        while (low <= high) {
            
            int mid = low + (high - low) / 2;

            //if end is <= target, its valid
            if(ends[mid] <= target ) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    
}
}
/**

 input - starttimes, endtimes, and profit (corresponding to i)

 output - max profit where no jobs overlap -- where the end of one is before the start of another


    TEST CASE:

    startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]



    IDEAS:
        have a fixed pointer where we compare all of the subsets, have a max for the curr profit, and return that
            this would be exponentional run time, inefficient 

            WILL THEY ALWAYS BE SORTED?

        sorting by non-overlapping intervals


    pair up [start, end, profit]
    sort by end 

    [1 3 50] [ 2 4 10] [3 5 40] [3 6 70]

    want to find the last job where the END < start[i] (curr)

        check if the value to the left of index I is less (sorted)
        BINARY SEARCH - whatever is to the left of I - the job ending before I starts 

        have an array where index i represents max profit until i
            
            At each job, theres 2 options:
                
                skip the job, best = arr[i-1]

                take the job, best = curr + recent max

                answer -- the last value in arr -- stores best up to that point 

        





 */
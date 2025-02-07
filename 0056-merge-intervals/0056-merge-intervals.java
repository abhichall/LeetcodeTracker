class Solution {
    public int[][] merge(int[][] intervals) { 
        
    if (intervals.length <= 1) return intervals;

    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

    LinkedList<int[]> merged = new LinkedList<>();


    for (int[] interval : intervals) {

        if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
            merged.add(interval);
        } else {
            merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
    }

    return merged.toArray(new int [merged.size()][]);
    }
}



        // // Step 1: Sort the intervals based on the start time
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // // Step 2: Use a list to merge intervals
        // LinkedList<int[]> merged = new LinkedList<>();

        // for (int[] interval : intervals) {
        //     // If list is empty or there's no overlap, add the interval
        //     if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        //         merged.add(interval);
        //     } else {
        //         // If overlap exists, merge by updating the last interval's end
        //         merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        //     }
        // }

        // // Convert list to array
        // return merged.toArray(new int[merged.size()][]);
    
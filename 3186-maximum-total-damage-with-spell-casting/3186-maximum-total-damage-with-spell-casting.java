class Solution {
    public long maximumTotalDamage(int[] power) {

        //edge case
        if (power == null || power.length == 0) return 0L;

        //aggregate the numbers -- unique values and their possible damage (itself * freq)
        HashMap<Integer, Long> hmap = new HashMap<>();
        for (int val : power) {
            hmap.put(val, hmap.getOrDefault(val, 0L) + (long) val);
        }
        
        //take these unqiue values and sort for easier understanding/access
        int n = hmap.size();
        int[] vals = new int[n];
        int index = 0;
        for (int key : hmap.keySet()) vals[index++] = key;
        Arrays.sort(vals);

        //dp -- dp]i] == best total damages using values up to i
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
           long totalForVal = hmap.get(vals[i]);

            // option 1: skip this value
            long skip = (i > 0) ? dp[i - 1] : 0L;

            // option 2: take this value => last compatible value must be <= vals[i] - 3
            int target = vals[i] - 3;

            // j = last index with vals[j] <= target
            int j = upperBound(vals, target) - 1;

            long take = totalForVal + (j >= 0 ? dp[j] : 0L);

            dp[i] = Math.max(skip, take);
        }

        return dp[n - 1];
    }

    // returns first index where a[idx] > target
    private int upperBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

/**


cant cast a spell for margin of i
not index, actual value itself


1 1 3 4 

index 0 -- [-1, 3] -- 4
index 1 -- [-1, 3] -- 4
index 2 -- [1, 5] -- 0
index 3 -- [2, 6] -- w

combine all the values that are the same and map them to their damaga eranges -- can make like a range
    have all unique damage ranges

take those distint values 


 */
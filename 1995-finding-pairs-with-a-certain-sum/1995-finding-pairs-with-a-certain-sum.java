class FindSumPairs {
     int[] nums1, nums2;
     Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();
        for (int x : nums2) {
            freq2.put(x, freq2.getOrDefault(x, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        freq2.put(oldVal, freq2.get(oldVal) - 1);
        if (freq2.get(oldVal) == 0) {
            freq2.remove(oldVal);
        }
        nums2[index] += val;
        int newVal = nums2[index];
        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int x : nums1) {
            int target = tot - x;
            res += freq2.getOrDefault(target, 0);
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */

 /**
 
 hashmap -- store freq

 input - nums1      num2

 static freq1 

 freq2

 VOID ADD(int index, int val)
    add val to nums2[index]


Count (int tot)
    return # of (i,j) such that nums[i] +nums2[j] = tot


Naively:

Every count(tot) could check all pairs: O(n * m) → too slow (10^6 operations per query).

Every add(index, val) changes only one element in nums2, but we don’t want to recompute everything from scratch.

add
    we are only changin num2 array so, only update that with the value, and have the freq

count
    since we are storing value and frequecy 
    unedrstand the tot - a will always equal the same b value
    can freq to optimze count of pairs

 
  */
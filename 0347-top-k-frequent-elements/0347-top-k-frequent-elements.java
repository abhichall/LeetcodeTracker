class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //hmap to keep track of occurences of each value
        Map<Integer, Integer> hmap = new HashMap<>();
        
        //populate hmap with occurences
        for (int n : nums) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        //create an array list to store the keys in relation the the occurence value

        //create array of size nums populate with array lists
        //array for bucket sort
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

      

            //populate each index (occ) with the key (nums)
        for (Map.Entry<Integer, Integer> pair : hmap.entrySet()) {

            int index = pair.getValue();
            buckets[index].add(pair.getKey());

        }
        
    int[] ans = new int[k];
    int counter = 0;
       for (int i = buckets.length - 1; i >= 0 ; i--) {

            for(int n : buckets[i]) {

                ans[counter] = n;
                counter++;

                if(counter == k) return ans;
            }
            

        }

    return new int []{};

        
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //hashmap
        Map<Integer, Integer> hmap = new HashMap<>();

        //populaate hmap with occ
        for (int n : nums) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        //create an array for the bucket sort values
        List<Integer>[] arr = new List[nums.length + 1];

        //populate the arr w arraylists
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        //iterate through hashmap
        for (Map.Entry<Integer, Integer> pairs : hmap.entrySet()) {
            
            int index = pairs.getValue();

            arr[index].add(pairs.getKey());
        }


        //finallly for the answer

        int[] ans = new int[k];
        int counter = 0;

        for (int i = arr.length - 1; i >= 0 ; i--) {

            for(int n : arr[i]) {

                ans[counter] = n;
                counter++;

                if(counter == k) return ans;
            }
            

        }

    return new int []{};

        
    }
}
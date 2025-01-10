class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Create hashmap to store values and the frequency of each value
        Map<Integer, Integer> hmap = new HashMap<>();

        // Add the values and frequencies to the hashmap
        for (int n : nums) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        // Create an array to hold a list of numbers at each frequency
        // The frequency of values can be from 0 to the max number in the array, so use length + 1
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Populate the frequency array by iterating through each pair in the hashmap
        for (Map.Entry<Integer, Integer> pairs : hmap.entrySet()) {
            int frequency = pairs.getValue();
            freq[frequency].add(pairs.getKey());
        }

        // Create an int array to store the answer
        int[] arr = new int[k];

        // Counter to stop after k elements
        int counter = 0;

        // Since more frequent values are at the rightmost, iterate from the end
        for (int i = freq.length - 1; i >= 0; i--) {

            for (int n : freq[i]) {
                arr[counter] = n;
                counter++;

                // Return the array once k elements are added
                if (counter == k) return arr;
            }
        }

        return arr;
    }
}

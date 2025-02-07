

class Solution {
    public String reorganizeString(String s) {
        // Step 1: Find the frequency of each letter
        int[] occ = new int[26];
        for (char c : s.toCharArray()) {
            occ[c - 'a']++;
        }

        // Step 2: Find the most frequent letter
        int maxFreq = 0, letterVal = 0;
        for (int i = 0; i < 26; i++) {
            if (occ[i] > maxFreq) {
                maxFreq = occ[i];
                letterVal = i; // Store index of most frequent character
            }
        }

        // Step 3: If maxFreq is greater than half the length, return ""
        if (maxFreq > (s.length() + 1) / 2) return "";

        // Step 4: Use a priority queue (max heap) to sort letters by frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (occ[i] > 0) {
                maxHeap.offer(new int[]{i, occ[i]}); // Store {letterIndex, frequency}
            }
        }

        // Step 5: Fill the result array with most frequent letters first
        char[] res = new char[s.length()];
        int idx = 0;

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int letterIdx = top[0]; // Character index
            int freq = top[1]; // Frequency

            while (freq-- > 0) {
                res[idx] = (char) (letterIdx + 'a');
                idx += 2; // Skip every other position

                if (idx >= s.length()) idx = 1; // If even indices are full, start filling odd indices
            }
        }

        return new String(res);
    }
}

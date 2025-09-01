class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) return result;

        // Frequency counts for p and current window in s
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int window = p.length();

        // Initial window
        for (int i = 0; i < window; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) result.add(0);

        // Slide the window
        for (int i = window; i < s.length(); i++) {
            // Add new char
            sCount[s.charAt(i) - 'a']++;
            // Remove leftmost char
            sCount[s.charAt(i - window) - 'a']--;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - window + 1);
            }
        }

        return result;
    }
}

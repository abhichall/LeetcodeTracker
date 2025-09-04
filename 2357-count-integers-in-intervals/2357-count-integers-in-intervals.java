import java.util.*;

class CountIntervals {
    private TreeMap<Integer, Integer> map;
    private long total;  // track number of covered integers

    public CountIntervals() {
        map = new TreeMap<>();
        total = 0;
    }

    public void add(int left, int right) {
        // Find the first interval that might overlap
        Map.Entry<Integer, Integer> entry = map.floorEntry(right);

        while (entry != null && entry.getValue() >= left) {
            int start = entry.getKey();
            int end = entry.getValue();

            // Remove its contribution
            total -= (end - start + 1);
            map.remove(start);

            // Expand our merging boundaries
            left = Math.min(left, start);
            right = Math.max(right, end);

            entry = map.floorEntry(right);
        }

        // Insert merged interval
        map.put(left, right);
        total += (right - left + 1);
    }

    public int count() {
        return (int) total;
    }
}

import java.util.*;

class Solution {
    
    // Memoization map to store previously computed powers
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int getKth(int lo, int hi, int k) {
        List<int[]> numbers = new ArrayList<>();
        
        // Calculate power of each number and store as [number, power]
        for (int i = lo; i <= hi; i++) {
            int power = getPower(i);
            numbers.add(new int[]{i, power});
        }
        
        // Sort by power first, then by integer value
        numbers.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        // return kth integer
        //since each is stored in the list as [number, power] return number
        return numbers.get(k - 1)[0];
    }
    
    // Recursive function with memoization
    private int getPower(int x) {
        if (x == 1) return 0;
        
        // Check if value already computed
        if (memo.containsKey(x)) {
            return memo.get(x);
        }
        
        int power;
        if (x % 2 == 0) {
            power = 1 + getPower(x / 2);
        } else {
            power = 1 + getPower(3 * x + 1);
        }
        
        // Store computed value in memo
        memo.put(x, power);
        
        return power;
    }
}

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hset = new HashSet<>();

        while (true) {

            //make sum reset each time
            int sum = 0;

            //add the digits
            while( n != 0) {
            sum += (int) Math.pow (n % 10, 2.0);
            n = n / 10;
        }

            if (sum == 1) {
                return true;
            }

            n = sum;

            if(hset.contains(n)) {
                return false;
            } else {
                hset.add(n);
            }
        }
        
    }
}
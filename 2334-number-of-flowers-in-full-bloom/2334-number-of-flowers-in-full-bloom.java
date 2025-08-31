
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Step 1: Build the event map
        for (int[] f : flowers) {
            map.put(f[0], map.getOrDefault(f[0], 0) + 1);     // start bloom
            map.put(f[1] + 1, map.getOrDefault(f[1] + 1, 0) - 1); // end bloom (exclusive)
        }

        // Step 2: Convert changes into prefix sums
        int curr = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            curr += entry.getValue();
            entry.setValue(curr);  // now map stores "flowers in bloom at this time"
        }

        // Step 3: Answer queries
        int[] result = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            Map.Entry<Integer, Integer> e = map.floorEntry(people[i]);
            result[i] = (e == null) ? 0 : e.getValue();
        }

        return result;
    }
}

/**

        input - 2d array - a beginning time for flowers in full bloomb, and then an ending time for flowers in full bloom
              - 1d array - at arr[i], the time that ith person came to see flowers 

        output - int 1d array - where each index is the number of flowers that are in full bloomb when the ith person is there


        // flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]

            i = 0 - time person came was 2, which means that answer[0] = 1 (flower in bloom)
            i = 1 - time person came was 3, which meants that answer[1] = 2 (flower in bloomb)


        idea 1:
            iterate through interval and people concurrently with a fixed pointer at people, only iterate once we find value in flowers -- counter  
            time complexity - o(n * m) - where n and m is the length of the arrays
            complex code 

        idea 2:
            start <= t <= end -- that counts as a flower 
            array of just start times, and an array of just end times - SORTED from lowest to greatest

            iteration through the people array - based on the arrival time i can find th enumber of flowers

                start <= t <= end

            flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11] -- 3

            start - [1 3 4 9]       end - [6 7 12 13]

    all bloom starts <= people[i]     all bloom ends < 3
                (2)                     (0)                     2 - 0 = answer              bloom in time = all starts <= time - all ends < time

                how to find the amount of flowers
                    linear search - o n * m
                    binary search -> o logn 
                        -- search for the value of time arrived PLUS 1 -- return the left pointer -- is the index of the last value <= time

                    i could perfrom binary search looking for <= in starts and just < in ends -- (onlogm)
                    



 */
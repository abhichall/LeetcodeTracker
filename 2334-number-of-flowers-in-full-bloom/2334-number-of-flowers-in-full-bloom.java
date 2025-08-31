
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        // Step 1 - get and create arrays for start and end times
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0]; // when flower starts blooming
            end[i] = flowers[i][1];   // when flower ends blooming
        }

        // Step 2 - sort the two arrays
        Arrays.sort(start);
        Arrays.sort(end);

        // Step 3 - iterate through people array and find answer
        int[] results = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int time = people[i];

            // # of flowers that started blooming by time
            int begin = upperBound(start, time);

            // # of flowers that already ended before time
            int finish = lowerBound(end, time);

            results[i] = begin - finish;
        }

        return results;
    }

    // upperBound: index of first element > target
    // => count of elements <= target
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1; // move right
            } else {
                right = mid; // mid might be the first greater
            }
        }
        return left;
    }

    // lowerBound: index of first element >= target
    // => count of elements < target
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1; // move right
            } else {
                right = mid; // mid might be >= target
            }
        }
        return left;
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
class Solution {
    public int longestMountain(int[] arr) {

    //edge cases 
    if (arr == null || arr.length < 3) return 0;

    //pointers
    int n = arr.length;
    int i = 0;

    //var to keep track of max
    int longest = 0;

    // iterate while there are still at least 3 values
    while (i < n - 2) {

        // 1) Ensure we skip parts that are not increasing from the left -- irrelevents
        if (arr[i] >= arr[i + 1]) {
            i++;
            continue; //re-enter the loop
        }

        // 2) Now climb up to peak -- keep going up until we encounter a value less then prev
        int climb = 0;
        int j = i; //ptr to current loc of i
        
        while(j + 1 < n && arr[j] < arr[j + 1]) {
            climb++; //will be used later to ensure valid mountain
            j++;    // keep track of array location
        }

        // 3) fall from peak
        int fall = 0;
        while ( j + 1 < n && arr[j] > arr[j + 1]) {
            fall++; //will be used later to ensure valid mountain
            j++;
        }

        //at this point we have established the amount of climbs and the amount of falls, so we need to see if its valid
        
        // 4) check validity - mtn needs to have at least one up and one down
        if (climb > 0 && fall > 0) {
            longest = Math.max(longest, climb + fall + 1); //the 1 is the peak value
        }

        // 5) iterate thru next
        i = j;
    }

    return longest;




    //     1) ensure we skip parts that are not increasing from the left -- irrelevents
    //     2) now we j go up until the increasing stops, we know its at its peak
    //     3) do same thing for the strictly decreasing portion
    //     4) check definition of valid mountain
    //         HAS TO BE at least 1 rising and 1 falling step
    //         if so, then do math.max and set to var
    //     5) iterate and move on to the next

        
    }
}


/**


what is a mountain

    the index is between 0 and the end of the array
    the left side is increasing
    the right side is decreasing



Input: arr = [2,1,4,7,3,2,5]

Output: 5


IDEAS

    iterate thru array, every value is the 'peak' -- go left and right from that peak to check the other restrictions
    time complexity - o n^2

    edge cases 
        fewer than 3 elements is invalid

    two pts
        end of array, one at 0

    iterate while there are still at least 3 values
        1) ensure we skip parts that are not increasing from the left -- irrelevents
        2) now we j go up until the increasing stops, we know its at its peak
        3) do same thing for the strictly decreasing portion
        4) check definition of valid mountain
            HAS TO BE at least 1 rising and 1 falling step
            if so, then do math.max and set to var
        5) iterate and move on to the next

    
    time complexity - o(n) space-  o(1)


 */
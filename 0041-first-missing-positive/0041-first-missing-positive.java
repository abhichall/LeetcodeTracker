class Solution {
    public int firstMissingPositive(int[] nums) {

        //set a variable for the length
        int n = nums.length;

        //iterate through the values in nums and swap the values into their corresponding
        //so nums[i] will be in nums[nums[i] - 1]
        for (int i = 0; i < n; i++) {
            
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {   
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
        }
    }
        //now since each value should be in corresponding index
        for(int j = 0; j < n; j++) {
            

            if ( nums[j] != j +1 ) {
                return j + 1;
            }

        }

        //this means that all values from 1 to n are there, so lowest positive is also n + 1
        return n + 1;
    }
}
// input(s) -- int[] nums -- unsorted

// output(s) -- int -- smallest positive integer that is not present in the input array

// TEST CASE:
    // [1, 2, 0]
        // will RETURN 3 becuase the 1 is minimum and 2 is maximum (POSITIVE MINIMUM and MAXIMUM)
    // [3, 4, -1, 1] -- ONLY CONSIDER POSITIVE NUMBERS
      // i = 0 -- 3 is positive --> nums[0] = 3 and num[3-1 ]

// QUESTIONS
    // is 0 considered postive? -- NO
    // can the input array be empty/null -- YES -- if then return what? NO

// LOGIC/IDEAS
    // Need to find the first missing POSITIVE integer starting at 1
    // MAIN KEY - if 1 - N is in the array, the LOWEST POSITIVE INTEGER IS (N+1)


    //first thought it to do arrays.sort to order the terms from lowest to highest
        // Time complexity -- O(nLogn)
    

    //its clear that the lowest positive integer must start at at least 1, and that if we are able to sort the array in order from 1 to N, then the answer is just n + 1
    // for (int n : nums)
        // n - and set it to its corresponding value so at index n - 1

        // in for loop we could have constraints -- n > 0 && n < lenngth of array && n != nums[n-1]
        // [3 4 -1 1] 
        // [-1 4  3 1]

        // [-1 1 3 4]
        // [1 -1 3 4]

        // index 1 is the only non negative value so then we make the answer that plus 1
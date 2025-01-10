class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ptr1 = m-1;         //this points to the last value that is being counted in the nums1 array
        int ptr2 = n-1;         //this points to the last value in the nums2 array
        int ptr3 = m + n - 1;   //this pointer holds the place of the very last value in the nums1 array


        while (ptr2 >= 0) {     //this makes sure that the sorting occurs only when the nums2 array is not empty

            if (ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]) {      //checks if there are values left in nums1 array and if so then checks the values in both arrays
                nums1[ptr3--] = nums1[ptr1--];                   // sets the last placeholder value that isnt being counted in the nums1 array to the lowest value that the ptr3 is at
               
           
            }
            else {            //checks which is bigger
                nums1[ptr3--] = nums2[ptr2--];                  // sets the last placeholder value that isnt being counted in the nums1 array to the lowest value that the ptr3 is at
               
            }









        }







        
    }
}
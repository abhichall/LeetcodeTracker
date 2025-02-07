class Solution {
    public int trap(int[] height) {

        //two pointers = one starts on both ends of array
        //

        //edge case
        if(height == null || height.length == 0) return 0;
        

        //ptrs for both ends of the array
        int left = 0;
        int right = height.length - 1;

        //to track maxes
        int leftMax = 0;
        int rightMax = 0;

        //to track the act ans
        int water = 0;

        while(left <= right) {
            if (height[left] < height[right]) { 
    // If the height at left is less than the height at right
    
    if (height[left] >= leftMax) { 
        // Check if current left height is greater than or equal to leftMax
        leftMax = height[left]; 
        // Update leftMax with the current left height
    } else { 
        // Else, current left height is less than leftMax
        water += leftMax - height[left]; 
        // Add the difference to water as trapped water at this index
    }
    
    // End if-else for left pointer
    left++; 
    // Move the left pointer one step to the right
} else { 
    // Else, height at right is less than or equal to height at left
    
    if (height[right] >= rightMax) { 
        // Check if current right height is greater than or equal to rightMax
        rightMax = height[right]; 
        // Update rightMax with the current right height
    } else { 
        // Else, current right height is less than rightMax
        water += rightMax - height[right]; 
        // Add the difference to water as trapped water at this index
    }
    
    // End if-else for right pointer
    right--; 
    // Move the right pointer one step to the left
}

// End if-else comparing left and right pointers



}
return water; 
// Return the total amount of trapped water

 }
}
// End of trap method

// End of
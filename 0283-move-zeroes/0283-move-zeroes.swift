class Solution {
    func moveZeroes(_ nums: inout [Int]) { //the inout allows for the inputs to be modified -- without, its passed in as a copy

      //write pointer - where the next non-zero value should be placed
      var write = 0;

      //iterate thru array
      for read in 0..<nums.count {
        
        //if current is a nonzero, then have to swap it
        if nums[read] != 0 {
          nums.swapAt(write, read)
          write = write + 1
        }
     }
  }
}
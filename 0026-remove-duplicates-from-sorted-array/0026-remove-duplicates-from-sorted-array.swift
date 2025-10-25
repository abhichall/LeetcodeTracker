class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
       
    //edge case
    if nums.isEmpty {return 0}

    //ptr
    var write = 1 //because this is the first place that can

    //iterate thry array 
    for read in 1..<nums.count {

      //if the curr value is different from the last written in value its a NEW element
      if nums[read] != nums[write - 1] {
        //place this new value at the write
        nums[write] = nums[read];
        write = write + 1;
      }
      //if its equal, comes here, means duplicate, means done up
    }

    return write
  }
}

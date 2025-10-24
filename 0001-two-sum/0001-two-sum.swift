class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {

        //dictionary to store index and complement value
        var indexByValue = [Int:Int]()

        //iterate over the given array
        for(currentIndex, value) in nums.enumerated() {

            //hold the complement value
            let complement = target - value

            //if this complement alr seen then we know that the answer is ready to return
            if let complementIndex = indexByValue[complement] { //unwrapping
                
                return [complementIndex, currentIndex];

            }

            indexByValue[value] = currentIndex

        }

        return []


        
    }
}
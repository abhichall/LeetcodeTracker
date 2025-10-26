class Solution {
    func productExceptSelf(_ nums: [Int]) -> [Int] {

        let n = nums.count

        //edge case
        if n == 0 {return []}
        if n == 1 { return [1]}

        var answer = Array(repeating: 1, count: n)

        //build the prefix
        for i in 1..<n {
            answer[i] = answer[i-1] * nums[i-1]
        }

        //take into account suffix
        var rightProd = 1
        for i in stride(from: n - 1, through: 0, by: -1) {

            answer[i] = answer[i] * rightProd
            rightProd *= nums[i]
        }

        return answer
        
    }
}


/* 

tkae index, multiple nevrything to the right(left) - on^2

prefix/ suffix product

array for answers

one pass thru input
    calculate prefix sum -- multiples to left

pass thru same input
    take into account everything on the right 


*/
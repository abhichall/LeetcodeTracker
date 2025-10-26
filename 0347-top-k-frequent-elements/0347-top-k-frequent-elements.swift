class Solution {
    func topKFrequent(_ nums: [Int], _ k: Int) -> [Int] {

        //edge case
        if nums.isEmpty {return []}

        //build freq dict
        var freq: [Int: Int] = [:]
        for n in nums {
            freq[n, default: 0] += 1
        }

        //impelement bucket sort 
        let n = nums.count
        var buckets = Array(repeating: [Int](), count: n + 1)

        //iterate and place in relative buckets
        for (n, count) in freq {
            buckets[count].append(n)
        }

        //find the results
        var result: [Int] = []
        var remaining = k
        var freqIndex = n

        while remaining > 0 && freqIndex >= 0 {

            if !buckets[freqIndex].isEmpty {

                for num in buckets[freqIndex] {
                    result.append(num)
                    remaining -= 1

                    if remaining == 0 {break}
                }
            }
            freqIndex -= 1
        }

        return result
        
    }
}

/*

have a hashamp -- key (value) -- count

top k -- bucket sort

have an array - indexed by frequency -- in each index, put in value that corresponds to that 

iterate backwards, return the top k

*/
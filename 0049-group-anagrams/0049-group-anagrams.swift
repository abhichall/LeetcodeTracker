class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {

        //each word shares the same number of letters, and counts of each letter

        //dict to store a 'key'
        var groups = [String : [String]]()

        for s in strs {
            var counts = Array(repeating: 0, count: 26)

            for byte in s.utf8 {

                let index = Int(byte) - 97

                if index >= 0 && index < 26 {
                    counts[index] += 1
                }


            }

        
        //convert to key
        let key = counts.map{ String($0)}.joined(separator: ",")

        groups[key, default: []].append(s)

        }
        return Array(groups.values)
        
    }
}
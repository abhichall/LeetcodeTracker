class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {

        //convert the input string into an array of char -- access
        let chars = Array(s)

        //dict initialize -- char --> most recent index seen
        var lastSeen: [Character: Int] = [:]

        //pointers
        var left = 0
        var maxLength = 0

        //iterate -- right ptr being the method of iteration
        for (right, ch) in chars.enumerated() {

            //if we see this
            if let prevIndex = lastSeen[ch], prevIndex >= left {
                left = prevIndex + 1
            }

            //update last seen
            lastSeen[ch] = right

            //updae hte max length -- right - left + 1
            let windowSize = right - left + 1
            if windowSize > maxLength {
                maxLength = windowSize
            }
        }
        return maxLength
    }
}

/*


substring - consecutive, continuous,
dont want duplicate charactets

tc - on
sc - 

dictionary -- map char - most recent

see a repeted char? move left pointer up until we remove that previous charact

two pointers - slide

*/
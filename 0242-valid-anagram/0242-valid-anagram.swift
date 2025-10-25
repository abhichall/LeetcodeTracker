class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {

        //edge case 
        if s.count != t.count {return false}

        //freq arra for 26 
        var counts = [Int](repeating: 0, count: 26)


        //helper constant -- for converting to a 0-based index
        let aScalar = Int(Character("a").unicodeScalars.first!.value)

        //increments
        for ch in s.unicodeScalars {
            
            let index = Int(ch.value) - aScalar
            counts[index] += 1
        }

        //decrements
        for ch in t.unicodeScalars {

            let index = Int(ch.value) - aScalar
            counts[index] -= 1

            //any point edge case
            if counts[index] < 0 {
                return false
            }

        }

        return true
        
    }
}

/*

if the same number of letters in s are == to the same number of letters in t

*/

class Solution {
    func isValid(_ s: String) -> Bool {
        
        if s.count % 2 == 1 {return false} // meaning if its odd number, cant possbily be a valid pair

        //create a dict to mape each opening to closing
        let matching: [Character: Character] = [ //key is closing
            ")": "(",
            "]": "[",
            "}": "{"
        ]

        //stach to hold the opening paranthesis values
        var stack: [Character] = []
        //stack,reserveCapacity(s.count)

        for ch in s{

            //if ch is closing bracket, have to check the top of the stack 
            if let expectedOpen = matching[ch] {

                //non matching
                if stack.isEmpty || stack.removeLast() != expectedOpen {
                    return false
                }

            } else {
                //it is opening
                stack.append(ch)
            }
            }
            return stack.isEmpty
    }
}
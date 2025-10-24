/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {
    func nextLargerNodes(_ head: ListNode?) -> [Int] {

        //edge case
        guard head != nil else {return []} //if not emnty then keep going, if not then we move

        //conveet the ll to an array
        var values = [Int]()
        var curr = head //pointer

        //iterate thru the ll -- unwrap safely
        while let node = curr {
            values.append(node.val)
            curr = node.next
        }

        //size of array
        let n = values.count

        //initalize the values to be 0 to be safe
        var result = Array(repeating: 0, count: n)
    
        //create a stack to have the higher up values
        var stack = [Int]()

        //iterate thru values-- put into stack or pop based on results
        for i in 0..<n {
            
            let currVal = values[i]

            // while curr value is greater than stored
            while let lastIndex = stack.last, values[lastIndex] < currVal { //while the stack is NOT empty, checking for optional == nil, and the value in array is greater

                stack.removeLast()
                result[lastIndex] = currVal
            }

            stack.append(i)
        }

        return result

        
    }
}



/*

will need to traverse the entire linked list at least once so TC will have to be at least o(N)
need to return an interger array so SC will be at least o(N)

node class
    val
    next ptr
    constructor

    convert this LL into an array -- have random access and wont have to iterate through over n^2 
    use a stack --go thru array, and when the curr avlue is greater than the top of the stack, we pop and set that as equal and push the current index if not

    any indexes left in the stack -- means are no larger values so j set that array value equal to 0


*/
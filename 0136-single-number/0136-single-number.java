class Solution {
    public int singleNumber(int[] nums) {
        
        //global variable to keep track
        int result = 0;

        for (int n : nums) result ^= n;

        return result;
    }
}

/**

in an array of integers, we have to find the only number that appears once


ideas
    hmap - find freq -- anything with a freq 1 -- we know is the answer


Bit Manipulation

XOR - if something is exclusive -- if two bits are the same, returns 0 -- diff returns 1

XOR all the numbers, any duplicate numbers will == 0, while any that doesnt -- freq 1

keep a global 
    iterate thru the array
    continuously xor every number 
    global should hold the only number that appears once 


test case
nums = [4, 1, 2, 1, 2] 

4 XOR 1 = 5 - 100 and 001 101 
5 XOR 2 = 7
7 XOR 1 = 6
6 XOR 2 = 4


 */
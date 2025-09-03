class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        //hashset implementation
        Set<Integer> prefix = new HashSet<>();

        //STEP 1 - iterate through arr1, and store prefixes
        for (int value : arr1) {

            int x = value;

            while (x > 0) {
                prefix.add(x); //add val to prefix
                x /= 10;       // shorten, take off the rightmost digit
            }
        } 
        //by this point, hashset is completely populated with all of the prefixes within arr1

        //global varibale to store the max lengths
        int max = 0;
        
        //iterate thru arr2
        for(int value : arr2) {

            int y = value;

            //to be able to count digits
            int length = countingDigits(y);

            while (y > 0) {

                //check if this value is in the prefix set

                if (prefix.contains(y)) { //means this is a valid prefix

                    if (length > max) max = length;

                }
                y /= 10;
                length--;
            }
        }

        return max;
    }

    private int countingDigits(int number) {
        int counter = 0;

        while(number > 0) {
            number /= 10;
            counter++;
        }
        return counter;
    }
}



/**




Prefix - starting from leftmost digit, integer formed -- 123 is a prefix of 12345
Common prefix - prefix found in both intergers a and b

input - two int arrays

output -- integer of the longost common prefix between all pairs, represent both inputs


input arrays can be different sizes 


Input: arr1 = [1,10,100], arr2 = [1000]
Output: 3

hset -- [1, 10, 100]

1000? -> 100? (hold this as max) -> 10



IDEAS

    could compare every pair (x,y) and iterate through each possibilty, and then could divide by 10 continuously -- time complexity (n * m * k)


    iterate thru arr1, generate ALL possible prefixes for each number -- divide by 10 continuously and store in hashset

    iterate thru arr2, is value present, if so store length of that value in global variable, and keep going 

 */
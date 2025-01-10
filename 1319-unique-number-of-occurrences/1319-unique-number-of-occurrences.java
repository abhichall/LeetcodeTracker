class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        //first, initialize a hashmap 
        //key: the value of the num itself, Value: the number of times it occurs

        Map<Integer, Integer> map = new HashMap<>();

        //iterate through the array, populating the hashmap with the value of the num and its occurences
        for (int nums : arr) {

            //the first nums will be the key - the actual value from the array
            //second one is gonna be the count
            map.put(nums, map.getOrDefault(nums, 0) + 1);

                          //this will check to see if nums is in the map, if it already is, it will take the value and +1; if not it will set 0, since it has not been counted for and then +1
        }
        

        //the values of the hashmap then can be put into a hashset
        //since a hashset only contains unique values, we can put all values from hashmap into hashset
        //and then if hashset size == to hashmap size, then return true

        Set<Integer> unique = new HashSet<>(map.values());
        //name.values takes only the values not the keys
        //so unique is now filled with all the occurences

        return map.size() == unique.size();
        
        
            }
}
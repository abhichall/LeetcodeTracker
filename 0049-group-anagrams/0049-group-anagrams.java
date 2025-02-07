class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //what happens if str was empty
        //walk through given test cases - make own test cases to try for understaind

        //hashmap to store sorted and then the corresponding vals
        Map<String, List<String>> hmap = new HashMap<>();

        // sorted val : values

        for(String s : strs) {

            char[] sort = s.toCharArray();
            Arrays.sort(sort);
            String key = new String(sort);

            if(hmap.containsKey(key)) {
                hmap.get(key).add(s);
            } else {
                hmap.put(key, new ArrayList<>());
                hmap.get(key).add(s);
            }

        }
        

        return new ArrayList<>(hmap.values());
        
    }
}
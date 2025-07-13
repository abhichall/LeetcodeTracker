class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hmap = new HashMap<>();

        for (String s: strs) {

            //take string
            // sort string
            // check to see if its in hmap
                // if so add to it
                // if not add it and then add to it

            // each key should also be in the list

            char[] sorted = s.toCharArray();

            Arrays.sort(sorted);
            
            String key = new String(sorted);

            if (hmap.containsKey(key)) {
                hmap.get(key).add(s);
            } else {
                hmap.put(key, new ArrayList<>());
                hmap.get(key).add(s);
            }
        }
        return new ArrayList<>(hmap.values());

    }
}
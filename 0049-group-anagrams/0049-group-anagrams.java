class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hmap = new HashMap<>();

        for (String s : strs) {

            char[] arr = s.toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

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
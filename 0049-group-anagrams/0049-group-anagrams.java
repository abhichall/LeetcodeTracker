class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> hmap = new HashMap<>();

        for (String s : strs) {

            char[] arr = s.toCharArray();

            Arrays.sort(arr);

            String upd = new String(arr);

            if(hmap.containsKey(upd)) {
                hmap.get(upd).add(s);
            } else {
                hmap.put(upd, new ArrayList<>());
                hmap.get(upd).add(s);
            }
        }

        return new ArrayList<>(hmap.values());
    }
}
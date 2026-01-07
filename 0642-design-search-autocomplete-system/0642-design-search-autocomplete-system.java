class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();  //charatcter --> trie node
        Map<String, Integer> count = new HashMap<>(); //find top matches
    }

    TrieNode root = new TrieNode(); // root of the trie
    StringBuilder curr = new StringBuilder(); // way to track current string

    public AutocompleteSystem(String[] sentences, int[] times) {

        for (int i = 0; i < sentences.length; i++) insert(sentences[i], times[i]); //iterate throuhgh and add to tries
    }

    private void insert(String s, int time) {
        //set our root
        //from root we add as like child
        TrieNode node = root;
        
        //trie stores by char
        for (char c: s.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.count.put(s, node.count.getOrDefault(s, 0) + time);
        }
    }
    
    public List<String> input(char c) {

        //stated by question, if we reach end of sentence, input in system, and then return empty array
        if (c == '#') {
            insert(curr.toString(), 1); //adds sentences to trie
            curr = new StringBuilder();
            return new ArrayList<>();
        }
        
        //didnt reach end of sentence 
        curr.append(c);
    
        //traverse from root folling each char curr
        TrieNode node = root;
        for (char ch: curr.toString().toCharArray()) {

            if(!node.children.containsKey(ch)) return new ArrayList<>();

            node = node.children.get(ch);
        }

        //to get the top 3
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>( 
            
            (a,b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return a.getKey().compareTo(b.getKey());
                }
                return b.getValue() - a.getValue();
            }
            
        );

        pq.addAll(node.count.entrySet());

        //way to store result
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().getKey());
        }

        return res;




        
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);

 suggests the top three most frequently types sentences 
    match the current inputs prefix
    update the data whenever a sentence - special character '#'

    ideas
        trie -- tree like DS -- each node represent a character -- the path from the root of tree 

 */
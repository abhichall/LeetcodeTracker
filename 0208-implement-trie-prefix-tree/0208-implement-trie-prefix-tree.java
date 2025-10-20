class Trie {

    private static class TrieNode {

        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    //initialize a root node
    final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root; //ptr to the root

        for(int i = 0; i < word.length(); i++) {

            char curr = word.charAt(i); //takes current character

            int index = curr - 'a'; //ascii values to get index

            if (node.children[index] == null) { //if nothing exists, make a new node
                node.children[index] = new TrieNode();
            }
            node = node.children[index]; //set curr pointer to the letter we are looking at
        }
        //mark the end of word
        node.isWord = true;
    }
    

    public boolean search(String word) {
        //ptr to the start
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);
            int index = c - 'a';

            if(node.children[index] == null) {
                return false; //letter not present -- not a word that we have accounted for
            }

            node = node.children[index];
        }

        //need to account for actually being the end of a word
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for(int i = 0; i < prefix.length(); i++) {
            
            char c = prefix.charAt(i);
            int index = c - 'a';

            if(node.children[index] == null) {
                return false; //letter not present -- not a word that we have accounted for
            }

            node = node.children[index];
        }

        //need to account for actually being the end of a word
        return true;

        
    }
}

/**

Trie -- b
            a       
                t
                r
letters will be all lowercase

TrieNode[] -- 26 values -- map out each letter of a word at its given 
boolean flag -- bat -- isWord = True


 */





/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
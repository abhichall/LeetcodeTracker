public class LRUCache {
    
    // Node class for Doubly Linked List
    private class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    // Constructor to initialize cache with a given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0); // Dummy head
        tail = new Node(0, 0); // Dummy tail
        
        head.next = tail;
        tail.prev = head;
    }

    // Get method to retrieve the value corresponding to the key
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }

    // Put method to insert or update a key-value pair in the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capacity) {
                Node tailPrev = tail.prev;
                remove(tailPrev);
                map.remove(tailPrev.key);
            }
        }
    }

    // Helper method to remove a node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to add a node right after the dummy head
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

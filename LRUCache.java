class LRUCache {

    Node head;
    Node tail;
    private Map<Integer,Node> map;
    private final int CAPACITY;
    
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if ( node != null ) {
            remove(node);
            addToHead(node);
            result = node.value;
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if (node != null) {
            remove(node);
            node.value = value;
            addToHead(node);
        } else {
            if ( map.size() == CAPACITY ) {
              remove(tail.prev);
              map.remove(tail.prev.key);  
            }
            
            node.key = key;
            node.value = value;
            
            map.put(key,node);
            addToHead(node);
        }
    }
    
    private void addToHead(Node node) {
        Node headNext = head.next;
        
        node.next = head.next;
        node.prev = head;
        
        head.next = node;
        headNext.prev = node;
    }
    
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
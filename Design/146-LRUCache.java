// If the key exists, we just update the value already stored there!


/*
// when put, point head to new node
// when get, move node to head
map = {{2, N1}, {1, N2}, {2, N3}}

get(2)
linked list = h->n2->n1<-t
*/
class LRUCache {
    
    class DoubleLinkedL {
        
        public DoubleLinkedL next;
        public DoubleLinkedL prev;
        public int val;
        public int key;
        
    }
        public void addToHead(DoubleLinkedL node){
            
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        
        // h->n2->n1->n3<-t
        public void updateMostRecent(DoubleLinkedL node){
            DoubleLinkedL prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;
            addToHead(node);
            
        }
        public int removeFromTail(){
            
            DoubleLinkedL toRemove = tail.prev;
            tail.prev = toRemove.prev;
            toRemove.prev.next = tail;
            
            return toRemove.key;
        }
        
    
    
    public DoubleLinkedL head;
    public DoubleLinkedL tail;
    private HashMap<Integer,DoubleLinkedL> map; 
    private int size;
    private int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, DoubleLinkedL>();
        size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedL();
        tail = new DoubleLinkedL();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            DoubleLinkedL mostRecent =  map.get(key);
            updateMostRecent(mostRecent);
            return mostRecent.val;
        }
    }
    
    public void put(int key, int value) {
        DoubleLinkedL exists = map.get(key);
        
        
        
        if(exists != null){
            exists.val = value;
            updateMostRecent(exists);
        }
        else{
            DoubleLinkedL toAdd = new DoubleLinkedL();
        
            toAdd.val = value;
            toAdd.key = key;
            if(size != capacity){
                map.put(key, toAdd);
                addToHead(toAdd);
                size++;
            }
            else{
                int removeKey = removeFromTail();
                map.remove(removeKey);
                map.put(key, toAdd);
                addToHead(toAdd);  
            }
        }
        
    }
}




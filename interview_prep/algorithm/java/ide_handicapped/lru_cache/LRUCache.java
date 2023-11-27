class LRUCache {

    //lookup in constant time
    private java.util.Map<Integer, CacheEntry> cache = new java.util.HashMap<>();
    private int capacity;
    // maintain an ordered list that quickly shuffle on access
    private CacheEntry mostRecently;
    private CacheEntry leastRecently;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.HashMap<>();
        this.mostRecently = new CacheEntry(0, 0);
        this.leastRecently = new CacheEntry(0, 0);
    
        this.mostRecently.prev = this.leastRecently;
        this.leastRecently.next = this.mostRecently;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            CacheEntry entry = cache.get(key);
            remove(entry);
            insert(entry);
            return entry.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
         if(cache.containsKey(key)){
            CacheEntry entry = cache.get(key);
            remove(entry);
        }
        CacheEntry refresh = new CacheEntry(key, value);
        cache.put(key, refresh);
        insert(refresh);
        
        if(cache.size()> capacity){
            CacheEntry oldest = this.leastRecently.next;
            remove(oldest);
            cache.remove(oldest.key);
        }

    }

    private void remove(CacheEntry entry){
        CacheEntry myPre = entry.prev;
        CacheEntry myNexEntry = entry.next;

        myPre.next = myNexEntry;
        myNexEntry.prev = myPre;
    }

    private void insert(CacheEntry entry){
        CacheEntry prev = this.mostRecently.prev;
        prev.next = entry;
        entry.prev = prev;
        this.mostRecently.prev = entry;
        entry.next = this.mostRecently;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.put(7, 7);

        assert cache.cache.size() == 5;
        assert cache.get(1) == -1;
        assert cache.get(2) == -1;
        assert cache.get(3) == 3;
        assert cache.get(4) == 4;
        
        cache.put(1, 100);
        assert cache.get(5) == -1;
        assert cache.get(3) == 3;
        assert cache.get(1) == 100;

        //System.out.println(cache);
    }

    public static class CacheEntry {
        private int key;
        private int val;
        CacheEntry next;
        CacheEntry prev;

        public CacheEntry(int key, int val){
            this.key = key;
            this.val = val;
        };
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        CacheEntry current = mostRecently.prev;

        while (current != leastRecently) {
            result.append("[").append(current.key).append(":").append(current.val).append("] ");
            current = current.prev;
        }

        return result.toString();
    }
}
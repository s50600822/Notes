import java.util.HashMap;
import java.util.LinkedHashSet;

public class Solution {
    private int cap;
    int lowestFreq = 1;
    java.util.Map<Integer, Entry> cache;
    java.util.Map<Integer, java.util.LinkedHashSet<Integer>> freqToKey;

    public Solution(int cap){
        this.cap = cap;
        lowestFreq = 1;
        freqToKey = new HashMap<>();
        cache = new HashMap<>();
    }

    public void put(int key, int value) {
        final Entry existing = cache.get(key);
        if(existing != null){
            existing.val = value;
            increaseFreq(existing);
            return;
        }

        if(cache.size() == cap){
            final LinkedHashSet evictingSet = freqToKey.get(lowestFreq);
            final int evictingKey = freqToKey.get(lowestFreq).iterator().next();
            cache.remove(evictingKey);
            evictingSet.remove(evictingKey);
        }

        final Entry newEntry = new Entry(key, value, 1);
        cache.put(key, newEntry);
        //System.out.println("add to freqToKey " + key + "--->1");
        LinkedHashSet<Integer> keys = freqToKey.getOrDefault(1,new LinkedHashSet<>());
        keys.add(key);
        freqToKey.put(1, keys);
        lowestFreq = 1;
    }

    public int get(int key) {
        final Entry e = cache.get(key);
        if(e == null) return -1;
        increaseFreq(e);
        return e.val;
    }

    public void increaseFreq(Entry e){
        int key = e.key;
        int prevFreq = e.freq;
        e.freq++;
        freqToKey.get(prevFreq).remove(key);
        LinkedHashSet<Integer> up = freqToKey.getOrDefault(e.freq, new LinkedHashSet<>());
        up.add(key);
        freqToKey.put(e.freq, up);
        if(freqToKey.get(prevFreq).isEmpty()) lowestFreq++;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/lfu-cache
        t1();
        t2();
    }

    private static void t2(){
        Solution cache = new Solution(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == 1;

        cache.put(3, 3);

        assert cache.get(2) == -1;
        assert cache.get(3) == 3;

        cache.put(2, 2);

        assert cache.get(1) == -1;
        assert cache.get(3) == 3;
    }
    private static void t1(){
        Solution cache = new Solution(2);
        cache.put(1, 1);
        cache.put(2, 2);

        assert cache.get(1) == 1;
        assert cache.get(2) == 2;

        cache.put(3, 3);
        cache.put(4, 4);

        assert cache.get(3) == -1: "3 hasn't been accessed";
    }

    static class Entry {
        int key;
        int val;
        int freq;
        Entry(int key, int val, int freq){
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
}
class Solution {
    int cap;
    int lowestFreq = 1;

    public Solution(int cap){
        this.cap = cap;
    }
    public void put(int key, int value) {}
    public int get(int key) {
        return -1;
    }

    public static void main(String[] args) {
        Solution cache = new Solution(2);
        cache.put(1, 1);
        cache.put(2, 2);

        assert cache.get(1) == 1;
        assert cache.get(2) == 2;

        cache.put(3, 3);
        cache.put(4, 4);

        assert cache.get(3) == -1: "3 hasn't been accessed";
    }
}
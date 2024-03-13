class Solution {
    static class MedianFinder {

        public final int RANGE = 100010;
        public int[] buckets = new int[RANGE * 2];
        public int midIndex = -1;
        public int midPos = -1;
        public int leftSize = 0;
        public int rightSize = 0;

        public void addNum(int num) {
            //-100_000 <= num <= 100_000
            // positive
            // at most 50_000 invo
            int idx = num + RANGE;
            buckets[idx] ++;
            if(midIndex == -1) {
                midIndex = idx;
            }
            if(idx == midIndex) {
                leftSize ++;
                midPos ++;
            } else if(idx < midIndex){
                leftSize ++;
            } else {
                rightSize ++;
            }
            if(leftSize >= rightSize + 2) {
                moveMid(true);
                leftSize --;
                rightSize ++;
            } else if(leftSize + 1 <= rightSize){
                moveMid(false);
                leftSize ++;
                rightSize --;
            }
        }


        public void moveMid(boolean toLeft) {
            if(toLeft) {
                if(midPos == 0) {
                    midIndex = nextMid(toLeft);
                    midPos = buckets[midIndex] - 1;
                } else {
                    midPos --;
                }
            } else {
                if(midPos == buckets[midIndex] - 1) {
                    midIndex = nextMid(toLeft);
                    midPos = 0;
                } else {
                    midPos ++;
                }
            }
        }

        public int nextMid(boolean toLeft) {
            int i = toLeft ? midIndex - 1 : midIndex + 1;
            while(buckets[i] == 0) {
                i = i + (toLeft ? -1 : 1);
            }
            return i;
        }


        public double findMedian() {
            double mid = (double) midIndex - RANGE;
            if((leftSize + rightSize) % 2 == 0) {
                int otherMid = ((midPos == buckets[midIndex] - 1) ? nextMid(false) : midIndex) - RANGE;
                return (mid + (double) otherMid) / (double) 2;
            } else {
                return mid;
            }
        }

    }
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-median-from-data-stream/description/
        t1();
        t2();
        t3();
        t4();
        // If all integer numbers from the stream are in the range [0, 100] => reduce RANGE
        // If 99% of all integer numbers from the stream are in the range [0, 100] => no need to buffer x RANGE
    }

    public static void t1(){
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        assert mf.findMedian() == 1.5;
        mf.addNum(3);
        assert mf.findMedian() == 2;
    }


    public static void t2() {
        MedianFinder mf = new MedianFinder();
        for (int i = 0; i < 10000; i++) mf.addNum(104);
        System.out.println("t2 Median : " + mf.findMedian());
        assert mf.findMedian() == 104;
    }

    public static void t3() {
        MedianFinder mf = new MedianFinder();
        for (int i = 0; i < 50_000; i++) mf.addNum(100_000);
        System.out.println("t3 Median : " + mf.findMedian());
        assert mf.findMedian() == 100_000;
    }

    public static void t4() {
        MedianFinder mf = new MedianFinder();
        for (int i = 0; i < 50_000; i++) mf.addNum(-100_000);
        System.out.println("t3 Median : " + mf.findMedian());
        assert mf.findMedian() == -100_000;
    }
}
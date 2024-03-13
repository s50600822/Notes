class Solution {
    static class MedianFinder {

        public final int RANGE = 100_001;
        public int[] buckets = new int[RANGE * 2];
        public int midIndex = -1;
        public int midPos = -1;
        public int leftSize = 0;
        public int rightSize = 0;

        public void addNum(int num) {
            //-100 000 <= num <= 100 000
            // positive
            buckets[num + RANGE] ++;
            if(midIndex == -1) {
                midIndex = num + RANGE;
            }
            if(num + RANGE == midIndex) {
                leftSize ++;
                midPos ++;
            } else if(num + RANGE < midIndex){
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
        t1();
        t2();
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

        // Add many elements close to the positive limit (104)
        for (int i = 0; i < 10000; i++) {
            mf.addNum(104);
        }

        // Add an unexpected element exceeding the buffer
        mf.addNum(200);
        // Try to find the median (might not be accurate)
        System.out.println("Median after adding unexpected element: " + mf.findMedian());
    }
}
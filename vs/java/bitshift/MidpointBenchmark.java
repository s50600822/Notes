public class MidpointBenchmark {
    public static void main(String[] args) {
        int l = 0;
        int r = 1000000000;

        long startTime = System.nanoTime();
        int midpoint = midpointBitwise(l, r);
        long endTime = System.nanoTime();
        long timeElapsedBitwise = endTime - startTime;
        System.out.println("Bitwise Right Shift Midpoint: " + midpoint);
        System.out.println("Time Elapsed (Bitwise): " + timeElapsedBitwise + " nanoseconds");

        startTime = System.nanoTime();
        midpoint = midpointDivision(l, r);
        endTime = System.nanoTime();
        long timeElapsedDivision = endTime - startTime;
        System.out.println("Normal Division Midpoint: " + midpoint);
        System.out.println("Time Elapsed (Division): " + timeElapsedDivision + " nanoseconds");
    }


    public static int midpointBitwise(int l, int r) {
        long startTime = System.nanoTime();
        int midpoint = (l + r) >> 1;
        long endTime = System.nanoTime();
        long timeElapsedBitwise = endTime - startTime;
        System.out.println("Bitwise Right Shift Midpoint: " + midpoint);
        System.out.println("Time Elapsed (Bitwise): " + timeElapsedBitwise + " nanoseconds");
        return (l + r) >> 1;
    }

    public static int midpointDivision(int l, int r) {
        return (l + r) / 2;
    }
}

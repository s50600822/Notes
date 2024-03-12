### (a + b) >> 1 vs (a + b)/2
```java
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
        return (l + r) >> 1;
    }

    public static int midpointDivision(int l, int r) {
        return (l + r) / 2;
    }
}

//javac MidpointBenchmark.java && java MidpointBenchmark
```

####result

```bash
Using java version 8.322.06.1-amzn in this shell.
➜  ~ javac MidpointBenchmark.java
➜  ~ java MidpointBenchmark
Bitwise Right Shift Midpoint: 500000000
Time Elapsed (Bitwise): 1667 nanoseconds
Normal Division Midpoint: 500000000
Time Elapsed (Division): 2125 nanoseconds



Using java version 21.0.2-graal in this shell.
➜  ~ javac MidpointBenchmark.java
➜  ~ java MidpointBenchmark
Bitwise Right Shift Midpoint: 500000000
Time Elapsed (Bitwise): 583 nanoseconds
Normal Division Midpoint: 500000000
Time Elapsed (Division): 750 nanoseconds
```
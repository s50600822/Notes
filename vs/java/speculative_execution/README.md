### Ref
https://en.wikipedia.org/wiki/Speculative_execution


### example

#### code
```java
public class SortedVsUnsortedArray {
    static final int LENGTH = 1000000;

    public static void main(String[] args) {

        int[] sortedArray = new int[LENGTH];
            for (int i = 0; i < LENGTH; i++) {
            sortedArray[i] = i;
        }
        
        int[] unsortedArray = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            unsortedArray[i] = i;
        }
        shuffleArray(unsortedArray);
        
        long startTime = System.nanoTime();
        touch(sortedArray);
        long endTime = System.nanoTime();
        long durationSorted = endTime - startTime;

        startTime = System.nanoTime();
        touch(unsortedArray);
        endTime = System.nanoTime();
        long durationUnsorted = endTime - startTime;

        System.out.println("Time taken for sorted array: " + durationSorted + " nanoseconds");
        System.out.println("Time taken for unsorted array: " + durationUnsorted + " nanoseconds");
    }

    /**
     * Fisher-Yates shuffle algorithm
     */ 
    private static void shuffleArray(int[] array) {
        int index, temp;
        for (int i = array.length - 1; i > 0; i--) {
            index = (int) (Math.random() * (i + 1));
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private static void touch(int[] arr) {
        for (int p = 0; p < arr.length; p++) {
            arr[p]++;
        }
    }   
}
```



#### observation
dew it `java SortedVsUnsortedArray.java && java SortedVsUnsortedArray`
```bash
for i in {1..7}; do java SortedVsUnsortedArray.java && java SortedVsUnsortedArray; done

Time taken for sorted array: 2234625 nanoseconds
Time taken for unsorted array: 3232291 nanoseconds
Time taken for sorted array: 2318583 nanoseconds
Time taken for unsorted array: 3390084 nanoseconds
Time taken for sorted array: 2592000 nanoseconds
Time taken for unsorted array: 1975041 nanoseconds
Time taken for sorted array: 2487416 nanoseconds
Time taken for unsorted array: 3636333 nanoseconds
Time taken for sorted array: 2494458 nanoseconds
Time taken for unsorted array: 1964666 nanoseconds
Time taken for sorted array: 2296417 nanoseconds
Time taken for unsorted array: 2056542 nanoseconds
Time taken for sorted array: 2391250 nanoseconds
Time taken for unsorted array: 3750333 nanoseconds
Time taken for sorted array: 2301084 nanoseconds
Time taken for unsorted array: 3297375 nanoseconds
Time taken for sorted array: 2475250 nanoseconds
Time taken for unsorted array: 3322667 nanoseconds
Time taken for sorted array: 2303584 nanoseconds
Time taken for unsorted array: 3338125 nanoseconds
Time taken for sorted array: 2431792 nanoseconds
Time taken for unsorted array: 3301833 nanoseconds
Time taken for sorted array: 2231875 nanoseconds
Time taken for unsorted array: 3311333 nanoseconds
Time taken for sorted array: 2451375 nanoseconds
Time taken for unsorted array: 1949875 nanoseconds
Time taken for sorted array: 2254917 nanoseconds
Time taken for unsorted array: 3331500 nanoseconds
```
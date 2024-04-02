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


### JS
```javascript
const length = 1000000;

function main() {
    const sortedArray = Array.from({ length }, (_, i) => i);
    const unsortedArray = Array.from({ length }, (_, i) => i);
    shuffleArray(unsortedArray);

    const startTimeUnsorted = performance.now();
    touch(unsortedArray);
    const durationUnsorted = performance.now() - startTimeUnsorted;

    const startTimeSorted = performance.now();
    touch(sortedArray);
    const durationSorted = performance.now() - startTimeSorted;

    console.log("Time taken for sorted array:", durationSorted);
    console.log("Time taken for unsorted array:", durationUnsorted);
}

function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}

function touch(arr) {
    for (let p = 0; p < arr.length; p++) {
        arr[p]++;
    }
}

main();
```

### Go

```go
use std::time::{SystemTime};

const LENGTH: usize = 1000000;

fn main() {
    let mut sorted_array = vec![0; LENGTH];
    for i in 0..LENGTH {
        sorted_array[i] = i as i32;
    }

    let mut unsorted_array = vec![0; LENGTH];
    for i in 0..LENGTH {
        unsorted_array[i] = i as i32;
    }
    shuffle_array(&mut unsorted_array);

    let start_time = SystemTime::now();
    touch(&mut sorted_array);
    let duration_sorted = start_time.elapsed().unwrap().as_nanos();

    let start_time = SystemTime::now();
    touch(&mut unsorted_array);
    let duration_unsorted = start_time.elapsed().unwrap().as_nanos();

    println!("Time taken for sorted array: {} nanoseconds", duration_sorted);
    println!("Time taken for unsorted array: {} nanoseconds", duration_unsorted);
}

fn shuffle_array(array: &mut [i32]) {
    let mut rng = SystemTime::now().duration_since(SystemTime::UNIX_EPOCH).unwrap().as_nanos() as u64;

    for i in (0..array.len()).rev() {
        let j = (rng % (i as u64 + 1)) as usize;
        rng = rng.wrapping_mul(6364136223846793005).wrapping_add(1);
        array.swap(i, j);
    }
}

fn touch(arr: &mut [i32]) {
    for p in arr.iter_mut() {
        *p += 1;
    }
}

```

### Rust

```rust
use std::time::{SystemTime};

const LENGTH: usize = 1000000;

fn main() {
    let mut sorted_array = vec![0; LENGTH];
    for i in 0..LENGTH {
        sorted_array[i] = i as i32;
    }

    let mut unsorted_array = vec![0; LENGTH];
    for i in 0..LENGTH {
        unsorted_array[i] = i as i32;
    }
    shuffle_array(&mut unsorted_array);

    let start_time = SystemTime::now();
    touch(&mut sorted_array);
    let duration_sorted = start_time.elapsed().unwrap().as_nanos();

    let start_time = SystemTime::now();
    touch(&mut unsorted_array);
    let duration_unsorted = start_time.elapsed().unwrap().as_nanos();

    println!("Time taken for sorted array: {} nanoseconds", duration_sorted);
    println!("Time taken for unsorted array: {} nanoseconds", duration_unsorted);
}

fn shuffle_array(array: &mut [i32]) {
    let mut rng = SystemTime::now().duration_since(SystemTime::UNIX_EPOCH).unwrap().as_nanos() as u64;

    for i in (0..array.len()).rev() {
        let j = (rng % (i as u64 + 1)) as usize;
        rng = rng.wrapping_mul(6364136223846793005).wrapping_add(1);
        array.swap(i, j);
    }
}

fn touch(arr: &mut [i32]) {
    for p in arr.iter_mut() {
        *p += 1;
    }
}
```


### C#
```bash
dotnet new console
code .
```

```csharp
namespace MyApp
{
    internal class Program
    {
        const int LENGTH = 1000000;

        public static void Main(string[] args)
        {
            int[] sortedArray = new int[LENGTH];
            for (int i = 0; i < LENGTH; i++)
            {
                sortedArray[i] = i;
            }

            int[] unsortedArray = new int[LENGTH];
            for (int i = 0; i < LENGTH; i++)
            {
                unsortedArray[i] = i;
            }
            ShuffleArray(unsortedArray);

            long startTime = DateTime.Now.Ticks;
            Touch(sortedArray);
            long endTime = DateTime.Now.Ticks;
            long durationSorted = endTime - startTime;

            startTime = DateTime.Now.Ticks;
            Touch(unsortedArray);
            endTime = DateTime.Now.Ticks;
            long durationUnsorted = endTime - startTime;

            Console.WriteLine("Time taken for sorted array: " + durationSorted + " ticks");
            Console.WriteLine("Time taken for unsorted array: " + durationUnsorted + " ticks");
        }

        /**
         * Fisher-Yates shuffle algorithm
         */
        private static void ShuffleArray(int[] array)
        {
            Random rng = new Random();
            int n = array.Length;
            while (n > 1)
            {
                n--;
                int k = rng.Next(n + 1);
                int temp = array[k];
                array[k] = array[n];
                array[n] = temp;
            }
        }

        private static void Touch(int[] arr)
        {
            for (int p = 0; p < arr.Length; p++)
            {
                arr[p]++;
            }
        }
    }
}
```


```bash
dotnet build && dotnet run
MSBuild version 17.5.1+f6fdcf537 for .NET
  Determining projects to restore...
  All projects are up-to-date for restore.
  csharp -> /Users/hoaphan/dev/csharp/bin/Debug/net7.0/csharp.dll

Build succeeded.
    0 Warning(s)
    0 Error(s)

Time Elapsed 00:00:00.53
Time taken for sorted array: 158330 ticks
Time taken for unsorted array: 14360 ticks
```
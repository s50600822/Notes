package sample;

public class Fibonacci {

  public static void main(String[] args) {
    // long start = System.currentTimeMillis();
    // long result = fib(Long.valueOf(args[0]));
    // long finish = System.currentTimeMillis();

    // long timeElapsed = finish - start;
    
    // System.out.println(String.format("startMs:[%d] endMs:[%d] elaspedMs:[%d] %s", start, finish, timeElapsed ,result));
    long start = System.nanoTime();
    long result = fib(Long.valueOf(args[0]));
    long finish = System.nanoTime();

    long timeElapsed = finish - start;
    
    System.out.println(String.format("startNs:[%d] elaspedNs:[%d] %d", start, timeElapsed ,result));    
  }
  
  // 92 maxed (93 for RUST u64)
  public static long fib(long n) {
      long a = 0, b = 1, c;
      if (n == 0) return a;
      for (long i = 2; i <= n; i++) {
          c = a + b;
          a = b;
          b = c;
      }
      return b;
  } 
}
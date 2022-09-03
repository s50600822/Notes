package sample;

public class Fibonacci {

  public static void main(String[] args) {
    System.out.println(fib(Long.valueOf(args[0])));
  }
  
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
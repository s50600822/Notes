package hoa.can.code.ez;

//https://practice.geeksforgeeks.org/problems/perfect-numbers3207/1
public class PerfectNumber {
    public static int isIt(long n){
        if(n<=1) return 0;
        long sumOfFactors = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
          if (n % i == 0) {
            sumOfFactors += i;
            sumOfFactors += n / i;
          }
        }
        if(sumOfFactors == n) return 1;
        return 0;
    }
}
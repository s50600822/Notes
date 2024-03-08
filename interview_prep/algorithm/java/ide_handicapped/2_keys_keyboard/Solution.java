class Solution {
    public int minSteps(int n) {
        int min = 0;
        if (n == 1)
            return 0;
        if (n % 2 == 0) {
            return min + 2 + minSteps(n / 2);
        }
        if (isPrime(n)) return n;
        int x = greatestPrimeFactor(n);
        return minSteps(x) + n / x;
    }


    public int greatestPrimeFactor(int nonPrimeOdd) {
        // note that this is a crook version where the input must not be a Prime or Even number
        // I'm not gonna put constrain check here for this is a dumb Leetcode game.
        int ans = 1;
        int i;
        // it's odd, so no need to test for 2 or evens
        for (i = 3; i < nonPrimeOdd; i +=2) {
            if (nonPrimeOdd % i == 0) {
                ans = i;
            }
        }
        //System.out.println("greatestPrimeFactor "+nonPrimeOdd+":"+ans);
        return ans;
    }

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/2-keys-keyboard/
        final Solution self = new Solution();
        assert self.greatestPrimeFactor(9) == 3;
        assert self.greatestPrimeFactor(15) == 5;
        assert self.greatestPrimeFactor(25) == 5;

        assert self.minSteps(1) == 0;
        assert self.minSteps(3) == 3;
        assert self.minSteps(9) == 6;
    }
}
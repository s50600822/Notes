package hoa.can.code.ez;

//https://leetcode.com/problems/repeated-substring-pattern/description/
public class RepeatedSubstringPattern {
    public static boolean solve(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    repeated.append(substring);
                }
                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
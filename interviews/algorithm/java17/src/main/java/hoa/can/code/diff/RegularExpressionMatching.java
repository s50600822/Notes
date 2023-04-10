package hoa.can.code.diff;

public class RegularExpressionMatching {
    public static boolean solve(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
                if (pc == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j-2] || ((sc == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                } else {
                    dp[i][j] = (sc == pc) && dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}

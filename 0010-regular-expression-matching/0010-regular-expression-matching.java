class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[n][m] = true; // empty matches empty

        for (int i = n; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                boolean firstMatch = (i < n &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

                // Check if next pattern is "*"
                if (j + 1 < m && p.charAt(j + 1) == '*') {
                    // 1) Skip the "x*"
                    // 2) Use "x*" if firstMatch
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    // Normal match
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}

/*

patterns
'.' -- matches any char
'*' -- matches zero or more

.* / *. -- whatcan match anything

**/
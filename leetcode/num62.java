package leetcode;

public class num62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        if (m == 1 || n == 1)
            return 1;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] += dp[i][j - 1];
                } else if (j == 0 && i != 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j != 0 && i != 0) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 1, n = 2;
        num62 s = new num62();
        System.out.println(s.uniquePaths(m, n));
    }
}
package interview;

/**
 * [程序员面试]：最小编辑代价
 */
public class minEditCost {
    public int minCost(String s1, String s2, int rc, int dc, int ic) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + rc;
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }

        }
        return dp[len1][len2];
    }
}
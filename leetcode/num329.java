package leetcode;

class num329 {
    int m = 0;
    int n = 0;
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int max = 0;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, Integer.MIN_VALUE);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int pre) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 0;
        if (matrix[i][j] <= pre)
            return 0;
        if (dp[i][j] > 0)
            return dp[i][j];
        int temp = Math.max(dfs(matrix, i, j + 1, matrix[i][j]), dfs(matrix, i + 1, j, matrix[i][j]));
        int temp0 = Math.max(dfs(matrix, i - 1, j, matrix[i][j]), dfs(matrix, i, j - 1, matrix[i][j]));
        dp[i][j] = Math.max(temp, temp0) + 1;
        return dp[i][j];
    }
}
package leetcode.shangtang;

import java.util.Scanner;

public class Solution2 {
    public static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public static int rows, columns;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        ++dp[i][j];
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && row < rows && col >= 0 && col < columns && matrix[row][col] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, row, col, dp) + 1);
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int result = longestIncreasingPath(matrix);
        System.out.println(result);
    }
}
package leetcode.pinduoduo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int result = numIslands(grid);
        System.out.println(result);
    }

    public static int numIslands(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        int count = 1;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, count);
                    count++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, merge(grid, i, j));
                }
            }
        }
        if (max == 0)
            return m * n;
        return max;
    }

    private static int merge(int[][] grid, int i, int j) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        if (i - 1 >= 0 && grid[i - 1][j] > 0)
            set.add(grid[i - 1][j]);
        if (j - 1 >= 0 && grid[i][j - 1] > 0)
            set.add(grid[i][j - 1]);
        if (i + 1 < grid.length && grid[i + 1][j] > 0)
            set.add(grid[i + 1][j]);
        if (j + 1 < grid[0].length && grid[i][j + 1] > 0)
            set.add(grid[i][j + 1]);
        for (Integer item : set) {
            sum += mark(grid, item);
        }
        return sum;
    }

    private static int mark(int[][] grid, int count) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == count) {
                    num++;
                }
            }
        }
        return num;
    }

    public static void dfs(int[][] grid, int i, int j, int count) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0)
            return;
        grid[i][j] = count;
        dfs(grid, i + 1, j, count);
        dfs(grid, i - 1, j, count);
        dfs(grid, i, j - 1, count);
        dfs(grid, i, j + 1, count);
    }
}
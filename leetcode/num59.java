package leetcode;

public class num59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;
        int index = 1;
        while (left <= right && up <= down) {
            for (int i=left; i<=right; i++) {
                res[up][i] = index ++;
            }
            for (int i=up+1; i<=down; i++) {
                res[i][right] = index ++;
            }
            if (left < right && up < down) {
                for (int i=right-1; i>=left; i--) {
                    res[down][i] = index ++;
                }
                for (int i=down-1; i>=up+1; i--) {
                    res[i][left] = index ++;
                }
            }
            left ++;
            right --;
            up ++;
            down --;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
    }
}
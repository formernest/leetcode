package leetcode.bilibili;


public class Solution2 {

    public static void main(String[] args) {
        
    }

    public static int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0? 0 : matrix[0].length;
        int[] result = new int[m*n];
        int index = 0;
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = m-1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) result[index++] = matrix[up][i];        
            for (int i = up+1; i <= down; i++) result[index++] = matrix[i][right];
            if (up < down && left < right) {
                for (int i = right-1; i >= left; i--) result[index++] = matrix[down][i];
                for (int i = down-1; i >= up+1; i--) result[index++] = matrix[i][left];
            }
            up ++;
            down --;
            left ++;
            right --;
        }
        return result;
    }
    
}

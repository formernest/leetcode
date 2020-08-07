package leetcode;
/**
 * 螺旋矩阵
 */
import java.util.LinkedList;
import java.util.List;

public class num54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        int n = m == 0? 0 : matrix[0].length;
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = m-1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) res.add(matrix[up][i]);        
            for (int i = up+1; i <= down; i++) res.add(matrix[i][right]);
            if (up < down && left < right) {
                for (int i = right-1; i >= left; i--) res.add(matrix[down][i]);
                for (int i = down-1; i >= up+1; i--) res.add(matrix[i][left]);
            }
            up ++;
            down --;
            left ++;
            right --;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{ 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }};
        List<Integer> res = spiralOrder(matrix);
        for (int i : res){
            System.out.println(i);
        }
    }
}
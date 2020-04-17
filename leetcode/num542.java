package leetcode;
/**
 * 0-1矩阵：求1到最近的0的距离
 * 思路：dp
 * 方法：1和最近的0的距离是横坐标和纵坐标差的和，其中0相对1的方位有左上、左下、右上、右下。
 *      采用1找0的方法找到每个方位的最小值。
 */
import java.util.Arrays;

public class num542 {
    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dist = new int[row][col];
        for(int i=0; i<row; i++){
            // 不能用Integer.MAX_VALUE，因为Integer.MAX_VALUE+1后为负数，出错。
            Arrays.fill(dist[i], Integer.MAX_VALUE/2);
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0)   dist[i][j] = 0;
            }
        }
        // 左上
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(i-1>=0) dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                if(j-1>=0) dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
            }
        }
        // 左下
        for(int i=row-1; i>=0; i--){
            for(int j=0; j<col; j++){
                if(i+1<row) dist[i][j] = Math.min(dist[i][j], dist[i+1][j]+1);
                if(j-1>=0)  dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
            }
        }
        // 右上
        for(int i=0; i<row; i++){
            for(int j=col-1; j>=0; j--){
                if(i-1>=0) dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                if(j+1<col) dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
            }
        }
        // 右下
        for(int i=row-1; i>=0; i--){
            for(int j=col-1; j>=0; j--){
                if(i+1<row) dist[i][j] = Math.min(dist[i][j], dist[i+1][j]+1);
                if(j+1<col) dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
        int[][] dist = updateMatrix(matrix);
        for(int[] arr:dist){
            for(int item:arr){
                System.out.print(item + "  ");
            }
            System.out.println();
        }
    }
}
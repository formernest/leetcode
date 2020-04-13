package interview;
/**
 * 程序员面试，龙与地下城游戏
 * 思路：dp
 * 每个位置的值为右边的值和下边的值减去当前值的最小值，同时也要满足当前值必须大于0
 * 先根据最后一个值求得最后一行和最后一列的最小值，然后再求中间元素的值
 */
public class dargonGame {
    public static int getMin(int[][] matrix){
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        matrix[m][n] = Math.max(1, 1-matrix[m][n]);
        for(int i=m-1; i>=0; i--){
            matrix[i][n] = Math.max(matrix[i+1][n]-matrix[i][n], 1);
        }
        for(int j=n-1; j>=0; j--){
            matrix[m][j] = Math.max(matrix[m][j+1]-matrix[m][j], 1);
            for(int i=m-1; i>=0; i--){
                int right = Math.max(matrix[i][j+1]-matrix[i][j], 1);
                int down = Math.max(matrix[i+1][j]-matrix[i][j], 1);
                matrix[i][j] = Math.min(right, down);
            }
        }
        return matrix[0][0];
    }
    public static void main(String[] args) {
        int[][] map = {{-2, -3, 3}, {-5, -10, 1}, {0, 30, -5}};
        System.out.println(getMin(map));
    }
}
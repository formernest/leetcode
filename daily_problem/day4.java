package daily_problem;
/**
 * 4-7 旋转矩阵
 */
public class day4 {
    public static void rotation(int[][] matrix){
        int length = matrix.length;
        for(int i=0; i<length; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<length; i++){
            for(int j=0; j<length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-j-1];
                matrix[i][length-j-1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
          };
        rotation(matrix);
        // for(int[] rows : matrix){
        //     for(int item : rows){
        //         System.out.print(item + ' ');
        //     }
        //     System.out.println();
        // }
    }
}
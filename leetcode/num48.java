class num48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        // 先沿着对角线翻转
        for(int i=0; i<m; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 沿着对称轴旋转
        for(int i=0; i<m; i++){
            for(int j=0; j<m/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
          };
        num48 solution = new num48();
        solution.rotate(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
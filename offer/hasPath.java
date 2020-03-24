
public class hasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[] flag = new int[matrix.length];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(help(matrix, rows, cols, i, j, 0, str, flag)) return true;
            }
        }
        return false;
    }
    public boolean help(char[] matrix, int rows, int cols, int row, int col, int index, char[] str, int[] flag){
        int num = row * cols + col;
        if(row<0||row>=rows||col<0||col>=cols||flag[num]==1||matrix[num]!=str[index])
            return false;
        if(index == str.length - 1)
            return true;
        flag[num] = 1;
        if(help(matrix, rows, cols, row+1, col, index+1, str, flag)||
            help(matrix, rows, cols, row-1, col, index+1, str, flag)||
            help(matrix, rows, cols, row, col+1, index+1, str, flag)||
            help(matrix, rows, cols, row, col-1, index+1, str, flag))
            return true;
        flag[num] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        int rows = 1;
        int col
    }
}
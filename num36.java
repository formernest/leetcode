import java.util.Arrays;

class num36 {
    public boolean isValidSudoku(char[][] board) {
        int[] digit = new int[10];
        for(int i=0; i<10; i++){
            digit[i] = i;
        }
        for(int i=0; i<9; i++){
            int[] array = Arrays.copyOf(digit,10);
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'&&array[board[i][j]]!=0){
                    array[board[i][j]] = 0;
                }else{
                    return false;
                }
            }
        }
        for(int i=0; i<9; i++){
            int[] array = Arrays.copyOf(digit,10);
            for(int j=0; j<9; j++){
                if(board[j][i]!='.'&&array[board[j][i]]!=0){
                    array[board[j][i]] = 0;
                }else{
                    return false;
                }
            }
        }
        
    }
}
package daily_problem;
/**
 * 生命游戏
 */
public class lifeGame {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] dire = {0, 1, -1};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int live_num = 0;
                for(int k=0; k<3; k++){
                    for(int t=0; t<3; t++){
                        if(dire[k] == 0 && dire[t] == 0) continue;
                        int r = i + dire[k];
                        int c = j + dire[t];
                        if((r>=0 && r<m) && (c>=0 && c<n) && Math.abs(board[r][c]) == 1){
                            live_num += 1;
                        }
                    }
                }
                if(board[i][j] == 1 && (live_num < 2 || live_num > 3)){
                    board[i][j] = -1;
                }
                if(board[i][j] == 0 && live_num == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] > 0){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }
}
package leetcode;
import java.util.ArrayList;
import java.util.List;
public class num51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] pos = new int[n];
        dfs(result, pos, 0, n);
        return result;
    }

    private void dfs(List<List<String>> result, int[] pos, int row, int n) {
        for(int i=0; i<n; i++) {
            pos[row] = i;
            if(isValid(pos, row)){
                if(row + 1 == n) {
                    addResult(result, pos);
                }else{
                    dfs(result, pos, row+1, n);
                }         
            }
        }
    }

    private void addResult(List<List<String>> result, int[] pos) {
        List<String> temp = new ArrayList<>();
        for(int i =0; i<pos.length; i++) {
            String s = "";
            for(int j = 0; j<pos.length; j++) {
                if(j == pos[i]) {
                    s += "Q";
                }else{
                    s += ".";
                }
            }
            temp.add(s);
        }
        result.add(temp);
    }

    private boolean isValid(int[] pos, int row) {
        for(int i=0; i<row; i++) {
            if(pos[i] == pos[row] || Math.abs(row - i) == Math.abs(pos[row] - pos[i])) {
                return false;
            }
        }
        return true;
    }
}

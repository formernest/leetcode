package others;

import java.util.Arrays;
import java.util.Scanner;

public class wangyi4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] map = new int[row][col];
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        int[][] result = new int[row][col];
        Arrays.fill(result, -1);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] == 0){
                    result[i][j] = 0;
                    tag(map, result, i, j);
                }  
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(result[i][j] == -1){
                    int temp = Integer.MAX_VALUE;
                    temp = Math.min(dfs(result, i+1, j), temp);
                    temp = Math.min(dfs(result, i-1, j), temp);
                    temp = Math.min(dfs(result, i, j-1), temp);
                    temp = Math.min(dfs(result, i, j+1), temp);
                    result[i][j] = temp;
                }  
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.println(result[i][j]);
            }
        }
    }
    public static void tag(int[][] map, int[][] result, int i, int j){
        if(i-1 >=0 && map[i-1][j] == 1) result[i-1][j] = 1;
        if(i+1 < map.length && map[i+1][j] == 1) result[i+1][j] = 1;
        if(j-1 >=0 && map[i][j-1] == 1) result[i][j-1] = 1;
        if(j+1 < map[0].length && map[i][j+1] == 1) result[i][j+1] = 1; 
    }
    public static int dfs(int[][] result, int i, int j){
        if(i < 0 || i>=result.length || j<0 || j>=result[0].length){
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        if(result[i][j] != -1) {
            res = Math.min(res, result[i][j] + 1);
        }else{
            res = Math.min(res, dfs(result, i, j));
        }
        return res;
    }
    
}
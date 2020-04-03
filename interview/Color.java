package interview;

import java.util.Arrays;
/*
着色问题
使用n中颜色对一个无向图着色，无向图的两边没有重复的颜色，求共有多少种解法
使用DFS+DP+回溯
1、dfs遍历相邻边的颜色，并且涂色
2、dp记录当前点的颜色，以便于比较
*/
public class Color{
    private int[][] graph;
    private int length;
    private int[] colors;
    private int sum;
    private int colorNum;
    public Color(int[][] matrix,int num){
        this.sum = 0;
        this.graph = matrix;
        this.length = matrix.length;
        this.colors = new int[this.length];  
        Arrays.fill(this.colors, 0); 
        this.colorNum = num;  
    }
    public int getSum(){
        dfs(0);
        return this.sum;
    }
    public void dfs(int k){ //深度遍历
        if(k == length){
            sum ++;
            return;
        }
        for(int i=1; i<=colorNum; i++){ //尝试着色
            colors[k] = i;
            if(Tcolor(k)){
                dfs(k+1);    // 可以着色，遍历下一个
            }
            colors[k] = 0;  // 回溯
        }
    }
    public boolean Tcolor(int k){
        for(int i = 0; i<length; i++){
            if(graph[k][i] == 1 && colors[k] == colors[i]){
                return false;   // 着色不成功
            }
        }
        return true;    // 着色成功
    }
    public static void main(String[] args) {
        int[][] input = {{1, 2},{1, 3},{1, 4},{2, 3},{2, 4},{2, 5},{3, 4},{4, 5}};
        int[][] graph = new int[5][5];
        for(int i=0; i<input.length; i++){
            int item1 = input[i][0];
            int item2 = input[i][1];
            graph[item1-1][item2-1] = 1;
            graph[item2-1][item1-1] = 1;
        }
        int num = 4;
        Color solution = new Color(graph, num);
        int result = solution.getSum();
        System.out.println(result);
    }
}
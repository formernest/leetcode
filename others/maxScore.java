package others;

import java.util.Stack;

public class maxScore{
    // public int max_score(int[] nums, int[] turns){
    //     int[] dp = new int[nums.length];
    //     int sum = 0;
    //     int max = 0;
    //     for(int i=0; i<nums.length; i++){
    //         dp[i] = 1;
    //         dfs(nums, dp, sum, max);
    //     }
    // }
    // public void dfs(int[] nums, int[] dp, int sum, int max){

    // }
    private int sum = 0;
    public int getNum(String str){
        int[] graph = new int[str.length()];
        int[] dp = new int[str.length()];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(i);
            }else{
                int pre = stack.pop();
                graph[pre] = i;
                graph[i] = pre;
            }
        }
        dfs(0, graph, dp);
        return sum;
    }
    public void dfs(int index, int[] graph, int[] dp){
        if(index == graph.length){
            sum += 1;
            for(int i:dp){
                System.out.print(i + "  ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=3; i++){
            dp[index] = i;
            if(okColor(index, graph, dp)){
                dfs(index+1, graph, dp);
            }
            dp[index] = 0;
        }
    }
    public boolean okColor(int index, int[] graph, int[] dp){
        if(dp[index] == dp[graph[index]]) return false;
        if(dp[index] == 2 && dp[graph[index]] == 3) return false;
        if(dp[index] == 3 && dp[graph[index]] == 2) return false;
        if(dp[index] == 2 || dp[index] == 3){
            if(index-1>=0 && dp[index-1] == dp[index]) return false;
            if(index+1<graph.length && dp[index+1] == dp[index]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        maxScore solution = new maxScore();
        int result = solution.getNum("((()))");
        System.out.println(result);
    }
}
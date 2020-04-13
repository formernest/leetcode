package leetcode;

public class num887 {
    // 递归
    public static int superEggDrop(int K, int N) {
        int min = process(N, K);
        return min;
    }
    public static int process(int N, int K){
        if(N == 0) return 0;
        if(K == 1) return N;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            min = Math.min(min, Math.max(process(i-1, K-1), process(N-i, K))); 
        }
        return min+1;
    }
    //动态规划
    public static int superEggDrop1(int K, int N) {
        if(K<0 || N<0) return 0;
        int[][] dp = new int[K+1][N+1];
        for(int i=0; i<=N; i++){
            dp[1][i] = i;
        }
        for(int i=2; i<=K; i++){
            for(int j=1; j<=N; j++){
                int min = Integer.MAX_VALUE;
                for(int k=1; k<=j; k++){
                    min = Math.min(min, Math.max(dp[i-1][k-1], dp[i][j-k]));
                }
                dp[i][j] = min+1;
            }
        }
        return dp[N][K];
    }
    public static void main(String[] args) {
        int K = 3;
        int N = 14;
        System.out.println(superEggDrop1(K, N));
    }
}
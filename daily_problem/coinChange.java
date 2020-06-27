package daily_problem;
/**
 * 换硬币数量
 */
public class coinChange {
    public static int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins={1, 5, 10, 25};
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=0; i<4; i++){
            for(int j=coins[i]; j<=n; j++){
                dp[j]=(dp[j]+dp[j-coins[i]])%mod;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        int result = waysToChange(n);
        System.out.println(result);
    }
}
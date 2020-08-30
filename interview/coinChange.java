package interview;

/**
 * 程序员面试：换钱的最小货币数
 */
import java.util.Arrays;

public class coinChange {
    public static int minChange(int[] coins, int aim) {
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= aim; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] >= 0) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[aim];
    }

    public static void main(String[] args) {
        int[] coins = { 3, 5 };
        int aim = 0;
        System.out.println(minChange(coins, aim));
    }
}
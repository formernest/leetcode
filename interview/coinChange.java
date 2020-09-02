package interview;

/**
 * [程序员面试]
 */
import java.util.Arrays;

public class coinChange {
    /**
     * 换钱的最小货币数
     * 
     * @param coins
     * @param aim
     * @return
     */
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

    /**
     * 换钱的方法数
     * 
     * @param coins
     * @param aim
     * @return
     */
    public static int numOfChange(int[] coins, int aim) {
        if (coins == null || coins.length == 0 || aim < 0)
            return 0;
        int[] dp = new int[aim + 1];
        for (int j = 0; coins[0] * j <= aim; j++) {
            dp[coins[0] * j] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - coins[i] >= 0 ? dp[j - coins[i]] : 0;
            }
        }
        return dp[aim];
    }

    public static void main(String[] args) {
        int[] coins = { 5, 10, 25, 1 };
        int aim = 0;
        System.out.println(numOfChange(coins, aim));
        aim = 15;
        System.out.println(numOfChange(coins, aim));
    }
}
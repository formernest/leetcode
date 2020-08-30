package interview;

/**
 * 程序员面试指南:打气球的最大分数 1、暴力递归 process(i, j)表示打爆[i, j]上气球的最大分数
 * 方式为先计算最后打爆i和最后打爆j的最大分数，然后计算最后打爆中间某个位置的最大分数 2、暴力递归转动态规划
 * 使用动态规划dp[i][j]表示只关注[i,j]区间的最大分数，因为i<j所以只有dp的上半区是有效的，
 * 而每个位置依赖于dp[i-1][j]和dp[i][j+1]，即其左边的所有位置和下方的所有位置， 使用行从下到上遍历的方式和列从左到右的方式。
 */
public class HitBalloon {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5 };
        int result = maxProfit(arr);
        System.out.println(result);
    }

    public static int maxProfit(int[] arr) {
        int N = arr.length;
        int[] help = new int[N + 2];
        help[0] = 1;
        help[N + 1] = 1;
        for (int i = 0; i < N; i++) {
            help[i + 1] = arr[i];
        }
        // return process(help, 1, N);
        int[][] dp = new int[N + 2][N + 2];
        for (int i = N; i > 0; i--) {
            for (int j = i; j <= N; j++) {
                if (i == j)
                    dp[i][j] = help[i - 1] * help[i] * help[j + 1];
                else {
                    dp[i][j] = Math.max(help[i - 1] * help[i] * help[j + 1] + dp[i + 1][j],
                            help[i - 1] * help[j + 1] * help[j] + dp[i][j - 1]);
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j],
                                help[i - 1] * help[j + 1] * help[k] + dp[i][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[1][N];
    }

    public static int process(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start - 1] * arr[start] * arr[end + 1];
        }
        int result = Math.max(arr[start - 1] * arr[start] * arr[end + 1] + process(arr, start + 1, end),
                arr[start - 1] * arr[end + 1] * arr[end] + process(arr, start, end - 1));
        for (int i = start + 1; i < end; i++) {
            result = Math.max(result,
                    arr[start - 1] * arr[end + 1] * arr[i] + process(arr, start, i - 1) + process(arr, i + 1, end));
        }
        return result;
    }
}
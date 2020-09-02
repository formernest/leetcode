package interview;

/**
 * [程序员面试]：机器人到达指定位置的方法数 dp dp[i][j] 表示剩余步数为i时到达当前位置的方法数 反向思路
 */
public class numOfMove {
    /**
     * 
     * @param N 位置总数
     * @param M 初始位置
     * @param K 移动步数
     * @param P 最终位置
     * @return
     */
    public static int getNum(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)
            return 0;
        int[][] dp = new int[K + 1][N + 1];
        // 假设可以到达最终位置，方向递推
        dp[0][P] = 1;
        // 每一行只依赖前一行
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        // 返回是否可以推到初始位置
        return dp[K][M];
    }

    public static void main(String[] args) {
        int result = getNum(3, 1, 3, 3);
        System.out.println(result);
    }
}
package leetcode.tencent;

import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int result = getNumber(line.substring(start - 1, end));
            System.out.println(result);
        }
    }

    private static int getNumber(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int len = chas.length;
        int[] dp = new int[len + 1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (chas[i] == chas[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0] + 1;
    }
}
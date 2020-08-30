package interview;

/**
 * 程序员面试：最长公共子串问题
 * 
 */
public class maxCommon {
    public static String getCommon(String s1, String s2) {
        String result = "";
        int max = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > max) {
                        max = Math.max(max, dp[i + 1][j + 1]);
                        result = s2.substring(j - max + 1, j + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "1AB2345CDE";
        String s2 = "12345EF";
        System.out.println(getCommon(s1, s2));
    }
}
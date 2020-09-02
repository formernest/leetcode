package interview;

/**
 * [程序员面试] 字符串的交错组成
 */
public class isCross {
    public static boolean iscross(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length()))
            return false;
        int l1 = s1.length();
        int l2 = s2.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        for (int i=1; i<=l1; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)){
                dp[i][0] = true;
            }
        }
        for (int i=1; i<=l2; i++) {
            if(s2.charAt(i-1) == s3.charAt(i-1)){
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if((s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        return dp[l1][l2];
    }
    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "12";
        String s3 = "AB2";
        boolean result = iscross(s1, s2, s3);
        System.out.println(result);
    }
}
package interview;
/**
 * 程序员面试：最长公共子序列问题
 * 思路：dp (dp[i][j]代表s1[0,i]和s2[0,j]中最长公共序列的长度)，通过dp数组重新构建res字符串
 */
public class longestCommonSub {
    public static String longCommon(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return "";
        }
        int len1 = s1.length();
        int len2 = s2.length();
        // dp
        int[][] dp = new int[len1][len2];
        dp[0][0] = s1.charAt(0) == s2.charAt(0)? 1:0;
        for(int i=1; i<len1; i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i) == s2.charAt(0)? 1:0;
        }
        for(int j=1; j<len2; j++){
            dp[0][j] = dp[0][j-1] + s1.charAt(0) == s2.charAt(j)? 1:0;
        }
        for(int i=1; i<len1; i++){
            for(int j=1; j<len2; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        // get result
        char[] res = new char[dp[len1-1][len2-1]];
        int index = res.length - 1;
        int m = len1 - 1;
        int n = len2 - 1;
        while(index >= 0){
            if(m > 0 && dp[m][n] == dp[m-1][n]){
                m--;
            }else if(n > 0 && dp[m][n] == dp[m][n-1]){
                n--;
            }else{
                res[index--] = s1.charAt(m);
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        String result = longCommon(s1, s2);
        System.out.println(result);
    }
}
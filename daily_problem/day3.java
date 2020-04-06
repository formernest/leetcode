package daily_problem;
/**
 * 最小编辑距离
 * dp[i][j]为s1[0:i]和s2[0:j]的最小编辑距离。
 * 其动态规划分为三种情况
 * 1、s1末尾插入一个字符
 * 2、s2末尾插入一个字符
 * 3、s1或者s2修改一个字符
 */
public class day3 {
    public static int minEditDistance(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=len2; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]));
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(minEditDistance(s1, s2));
    }
}
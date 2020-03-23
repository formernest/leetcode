public class num115{
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int[][] dp = new int[lt+1][ls+1];
        for(int i=0; i<=ls; i++) dp[0][i] = 1;
        for(int i=1; i<=lt; i++){
            for(int j=1; j<=ls; j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[lt][ls];
    }
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        num115 solution = new num115();
        System.out.println(solution.numDistinct(s, t));
    }
}
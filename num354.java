import java.util.Arrays;

class num354 {
    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        if(m == 0) return 0;
        int[] dp = new int[m+1];
        Arrays.sort(envelopes, (int[] a1, int[] a2)->(a1[0]-a2[0]));
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<m; i++){
            for(int j=0; j<i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
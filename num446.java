import java.util.Arrays;

class num446 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int len = A.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int count = 0;
        int temp = A[1] - A[0];
        dp[1] = 1;
        for(int i=2; i<len; i++){
            if(A[i]-A[i-1] == temp){
                dp[i] = dp[i-1] + 1;
            }else{
                if(dp[i-1] >= 2) count += (Math.pow(2, dp[i-1]-1) - 1);
                temp = A[i]-A[i-1];
                dp[i] = 1;
            }
        }
        return dp[len-1] >= 2? count + (int)Math.pow(2, dp[len-1]-1)-1 : count;   
    }
    public static void main(String[] args) {
        int[] A = {2, 4, 6, 8, 10};
        num446 s = new num446();
        System.out.println(s.numberOfArithmeticSlices(A));
    }
}
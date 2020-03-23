/*
将一个数组分为两个数组，使两个数组和的差最小
*/
public class SplitArray{
    public int diff(int[] array){
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
        }
        int[][] dp = new int[array.length+1][sum/2+1];
        for(int i=1; i<=array.length; i++){
            for(int j=1; j<=sum/2; j++){
                if(j-array[i-1]>=0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-array[i-1]] + array[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return sum - 2*dp[array.length][sum/2];
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,7,2,4};
        SplitArray solution = new SplitArray();
        System.out.println(solution.diff(arr));
    }
}
package leetcode.ali;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr =  new int[n][2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i =0; i<n; i++){
            arr[i][0] = scanner.nextInt();
            min = min > arr[i][0]? arr[i][0] : min;
            arr[i][1] = scanner.nextInt();
            max = max > arr[i][1]? max : arr[i][1];
        }
        int curmax = 0;
        int[] dp = new int[max];
        for(int i=0; i<n; i++){
            int result = markdp(dp, arr[i][0], arr[i][1]);
            curmax = curmax < result? result : curmax;
        }
        System.out.println(curmax);
    }
    public static int markdp(int[] dp, int start, int end){
        int max = 0;
        for (int i=start; i<end; i++) {
            dp[i] += 1;
            max = dp[i] > max? dp[i] : max;
        }
        return max;
    }
}
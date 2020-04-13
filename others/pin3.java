package others;

import java.util.Scanner;

public class pin3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] dp = new int[10];
        int[] arr = new int[N];
        scanner.nextLine();
        String s = scanner.nextLine();
        char[] char_arr = s.toCharArray();
        for(int i=0; i<char_arr.length; i++){
            arr[i] = char_arr[i] - '0';
            dp[arr[i]] += 1;
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0; i<10; i++){
            if(dp[i] > 0){
                int cost = minCost(arr, dp, i, K);
                if(cost < min){
                    min = cost;
                    index = i;
                }
            }
        }
        System.out.println(min);
        System.out.println(index);
    }
    public static int minCost(int[] arr, int[] dp, int n, int k){
        int cost = 0;
        k -= Math.min(k, dp[n]);
        if(k == 0){
            return cost;
        }
        for(int i=1; i<dp.length; i++){
           if(n+i < dp.length){
               int min = Math.min(k, dp[n+i]);
               cost += Math.abs(i) * min;
               k -= min;
               if(k == 0){
                   return cost;
               }
           }
           if(n-i >= 0){
                int min = Math.min(k, dp[n-i]);
                cost += Math.abs(i) * min;
                k -= min;
                if(k == 0){
                    return cost;
                }
           }
        }
        return cost;
    }
}
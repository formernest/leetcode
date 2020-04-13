package others;

import java.util.Scanner;

public class pin2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        int count = 0;
        long sum = 0;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                sum += arr[j];
                if(sum % M == 0){
                    count += 1;
                }
            }
            sum = 0;
        }
        System.out.println(count);
    }
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int N = scanner.nextInt();
    //     int M = scanner.nextInt();
    //     int[] arr = new int[N];
    //     for(int i=0; i<N; i++){
    //         arr[i] = scanner.nextInt();
    //     }
    //     int[] dp = new int[M];
    //     int count = 0;
    //     long sum = 0;
    //     for(int i=0; i<N; i++){
    //         sum += arr[i];
    //         int current = (int)sum % M;
    //         count += dp[current];
    //         dp[current] += 1;
    //     }
    //     // count += dp[0];
    //     System.out.println(count);
    // }
}
package others;

import java.util.Scanner;

public class wangyi1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextLong();
        }
        long current = -1;
        for(int i=1; i<n; i++){
            if(arr[i]-arr[i-1] < 1){
                current = -1;
                break;
            }else{
                long temp = arr[i] - arr[i-1];
                if(current == -1){
                    current = temp;
                }else{
                    current = maxDiv(temp, current);
                }
            }
        }
        System.out.println(current);
    }
    public static long maxDiv(long l1, long l2){
        long temp;
        if(l1 < l2){
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        while(l1%l2 != 0){
            temp = l1 % l2;
            l1 = l2;
            l2 = temp;
        }
        return l2;
    }
}
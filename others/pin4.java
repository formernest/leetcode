package others;

import java.util.Scanner;

public class pin4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        int[] dp_left = new int[N];
        int[] dp_right = new int[N];
        int current = arr[0];
        int count = 1;
        for(int i=1; i<N; i++){
            if(arr[i] == arr[i-1]){
                dp_left[i] = count;
                count ++;  
            }else{
                current = arr[i];
                dp_left[i] = count;
                count = 1;
            }
            // System.out.println(dp_left[i]);
        }
        current = arr[N-1];
        count = 1;
        for(int i=N-2; i>=0; i--){
            if(arr[i] == arr[i+1]){
                dp_right[i] = count;
                count ++;
            }else{
                current = arr[i];
                dp_right[i] = count;
                count = 1;
            }
            // System.out.println(dp_left[i]);
        }
        for(int i=0; i<N; i++){
            if(i-1>=0 && i+1<N && arr[i-1] == arr[i+1]){
                dp_left[i] = dp_left[i]+dp_right[i];
            }
        }
        
    }
}
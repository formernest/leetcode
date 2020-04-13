package others;

import java.util.Arrays;
import java.util.Scanner;

public class pin1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        long sum = 0;
        int i = n-1;
        for(i=n-1; i>=2; i-=3){
            sum += arr[i];
            sum += arr[i-1];
        }
        while(i>=0){
            sum += arr[i];
            i--;
        }
        System.out.println(sum);
    }
}
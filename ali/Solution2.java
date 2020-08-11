package ali;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        arr[0] = 0;
        for (int i=1; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i=0; i<m; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            char result = level(arr, num1) <= level(arr, num2)? 'A' : 'B';
            System.out.println(result);
        }
    }
    public static int level(int[] arr, int current){
        int count = 0;
        while (current != 0) {
            current = arr[current-1];
            count ++;
        }
        return count;
    }
}
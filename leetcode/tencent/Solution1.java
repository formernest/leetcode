package leetcode.tencent;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[m-1];
        for (int i=0; i<m; i++) {
            if (i <= n-1) {
                arr[i] = scanner.nextInt();
            } else {
                arr[i-1] = scanner.nextInt();
            }
        }
        for (int i=0; i<m-1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
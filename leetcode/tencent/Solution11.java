package leetcode.tencent;

import java.util.Scanner;

public class Solution11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < n && index2 < m) {
            if (arr1[index1] == arr2[index2]) {
                System.out.print(arr1[index1] + " ");
                index1++;
                index2++;
            }else if (arr1[index1] > arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
    }
}

package leetcode.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Solution14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        for (int i = 0; i < num; i++) {
            if (arr[i] < arr2[num/2]) {
                System.out.println(arr2[num / 2]);
            } else {
                System.out.println(arr2[num / 2 - 1]);
            }
        }
    }
}

package leetcode.wangyi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
            set.add(arr[i]);
        }
        int[] arr1 = new int[n - m];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            arr1[j++] = i;
        }
        int i = 0;
        j = 0;
        String result = "";
        while (i < m && j < n - m) {
            if (arr[i] < arr1[j]) {
                result += arr[i++];
            } else {
                result += arr1[j++];
            }
            result += " ";
        }
        while (i < m) {
            result += arr[i++];
            result += " ";
        }
        while (j < n - m) {
            result += arr1[j++];
            result += " ";
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}
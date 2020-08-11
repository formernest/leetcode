package ali;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        long ans = 0;
        while(left < right) {
            ans += arr[right--] - arr[left++];
        }
        System.out.println(ans);
    }
}
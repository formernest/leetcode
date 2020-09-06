package leetcode.sougo;

import java.util.Arrays;

public class Solution1 {
    public static int numberofprize(int a, int b, int c) {
        int[] arr = { a, b, c };
        Arrays.sort(arr);
        int count = arr[0];
        int remain = arr[1] + arr[2] - 2 * arr[0];
        while (remain >= 4) {
            int r1 = arr[1] - count;
            int r2 = arr[2] - count;
            if (r1 >= 2 && r2 >= 2) {
                arr[1] -= 1;
                arr[2] -= 1;
                count += 1;
            } else if (r1 == 1 && r2 >= 3) {
                count += 1;
                arr[2] -= 2;
            } else if (r1 >= 3 && r2 == 1) {
                count += 1;
                arr[1] -= 2;
            } else if (r1 == 0 && r2 >= 5) {
                count += r2 / 5;
                break;
            } else if (r2 == 0 && r1 >= 5) {
                count += r1 / 5;
                break;
            }
            remain = arr[1] + arr[2] - 2 * arr[0];
        }
        return count;
    }
    public static void main(String[] args) {
        int result = numberofprize(9, 3, 3);
        System.out.println(result);
    }
}

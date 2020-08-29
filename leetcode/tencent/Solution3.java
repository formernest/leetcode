package leetcode.tencent;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n; i++) {
            long result = getMaxValue(scanner.nextLong());
            System.out.println(result);
        }
    }

    private static long getMaxValue(long l) {
        long max = getAdd(l);
        for (int i = 0; i <= l / 2; i++) {
            max = Math.max(max, getAdd(i) + getAdd(l - i));
        }
        return max;
    }

    private static long getAdd(long nextInt) {
        long result = 0;
        while(nextInt != 0) {
            result += nextInt%10;
            nextInt /= 10;
        }
        return result;
    }


}
package leetcode.tencent;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] height = new int[number];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < number; i++) {
            height[i] = scanner.nextInt();
            min = Math.min(min, height[i]);
            max = Math.max(max, height[i]);
        }
        int count = min;
        while (++min <= max) {
            for (int i = 0; i < number; i++) {
                if (height[i] < min && i-1 >=0 && height[i-1] >= min) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
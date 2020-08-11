package leetcode.wangyi;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i=0; i<n; i++){
            long num = scanner.nextLong();
            if (num <= 1) continue;
            if (num % 2 == 1) count += 1 + (num-3)/2;
            else count += num / 2;
        }
        System.out.println(count);
    }
}
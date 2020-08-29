package leetcode.bigo;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number % 2 == 1)
            System.out.println(0);
        int count = 0;
        int c = number % 10 / 2;
        int a = number / 100 / 2;
        int acc = a * 100 + c * 10 + c;
        int abc = number - acc;
        System.out.println(1);
        System.out.println(abc + " " + acc);
    }
}
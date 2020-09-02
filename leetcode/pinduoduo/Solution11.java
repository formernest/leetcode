package leetcode.pinduoduo;

import java.util.Scanner;

public class Solution11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] result = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j || i + j == num - 1 || (num % 2 == 1 && (i == num / 2 || j == num / 2))) {
                    result[i][j] = 0;
                } else {
                    if (i < num / 2 && j < num / 2) {
                        if (i < j)
                            result[i][j] = 2;
                        if (j < i)
                            result[i][j] = 3;
                    }
                    if (i < num / 2 && j >= num / 2) {
                        if (i + j < num - 1)
                            result[i][j] = 1;
                        else
                            result[i][j] = 8;
                    }
                    if (i >= num / 2 && j < num / 2) {
                        if (i + j < num - 1)
                            result[i][j] = 4;
                        else
                            result[i][j] = 5;
                    }
                    if (i >= num / 2 && j >= num / 2) {
                        if (i < j)
                            result[i][j] = 7;
                        if (j < i)
                            result[i][j] = 6;
                    }
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
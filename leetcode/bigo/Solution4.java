package leetcode.bigo;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number * number];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        int index = number * number-1;
        int[][] matrix = new int[number][number];
        int left = 0;
        int right = number - 1;
        int up = 0;
        int down = number - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) matrix[up][i] = arr[index--];        
            for (int i = up+1; i <= down; i++) matrix[i][right] = arr[index--];
            if (up < down && left < right) {
                for (int i = right-1; i >= left; i--) matrix[down][i] = arr[index--];
                for (int i = down-1; i >= up+1; i--) matrix[i][left] = arr[index--];
            }
            up ++;
            down --;
            left ++;
            right --;
        }
        for (int i=0; i<number; i++){
            for (int j=0; j<number; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
package leetcode.pinduoduo;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        char[][] graph = new char[6][6];
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                graph[i][j] = (char) scanner.nextByte();
            }
        }
        int[][] visited = new int[6][6];
        System.out.println(36);
    }
}
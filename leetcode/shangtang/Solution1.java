package leetcode.shangtang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] mark = new int[s.length()];
        String temp = "";
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'G') {
                queue.add(i);
                mark[i] = 1;
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = current + 1; i < s.length(); i++) {
                if (mark[i] == 1)
                    continue;
                if (s.charAt(i) == 'o') {
                    if ("".equals(temp)) {
                        temp += 'o';
                        mark[i] = 1;
                    } else if ("o".equals(temp)) {
                        temp += 'o';
                        mark[i] = 1;
                    }
                }
                if (s.charAt(i) == 'd' && "oo".equals(temp)) {
                    temp = "";
                    mark[i] = 1;
                    count += 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
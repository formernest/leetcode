package leetcode.tencent;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<String> set = new HashSet<>();
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        int k = scanner.nextInt();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j<s.length(); j++) {
                if (!set.contains(s.substring(i, j))) {
                    set.add(s.substring(i, j));
                    queue.offer(s.substring(i, j));
                    if (queue.size() > k) {
                        queue.poll();
                    }
                }
            }
        }
        String result = queue.peek();
        System.out.println(result);
    }
}
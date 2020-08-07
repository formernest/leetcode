package leetcode.ali;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] money = new int[n];
        NodeList[] graph = new NodeList[n];
        for (int i=0; i<n; i++) {
            money[i] = scanner.nextInt();
            graph[i].list.add(scanner.nextInt()-1);
        }
        
    }
}
class NodeList {
    public ArrayList<Integer> list;
}
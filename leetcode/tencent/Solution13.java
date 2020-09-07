package leetcode.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Solution13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        TreeMap<String, Integer> treeMapMin = new TreeMap<>();
        TreeMap<String, Integer> treeMapMax = new TreeMap<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            int value = treeMapMin.getOrDefault(s, 0);
            treeMapMin.put(s, value + 1);
            value = treeMapMax.getOrDefault(s, 0);
            treeMapMax.put(s, value + 1);
        }
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(treeMapMin.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            // 升序排序
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        List<Entry<String, Integer>> list1 = new ArrayList<Entry<String, Integer>>(treeMapMax.entrySet());

        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            // 降序排序
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int size = Math.min(k, treeMapMax.size());
        for (int i = 0; i < size; i++) {
            Entry<String, Integer> entry = treeMapMax.pollFirstEntry();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (int i = 0; i < size; i++) {
            Entry<String, Integer> entry = treeMapMin.pollFirstEntry();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

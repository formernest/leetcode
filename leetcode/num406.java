package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class num406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            res.add(person[1], person);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        num406 s = new num406();
        int[][] res = s.reconstructQueue(people);
        for (int[] item : res) {
            System.out.println(item[0] + '\t' + item[1]);
        }
    }
}
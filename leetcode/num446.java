package leetcode;

import java.util.HashMap;
import java.util.Map;

class num446 {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        long ans = 0;
        Map<Integer, Integer>[] map = new Map[len];
        for (int i = 0; i < len; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long delta = (long) A[i] - (long) A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) delta;
                int sum = map[j].getOrDefault(diff, 0);
                int origin = map[i].getOrDefault(diff, 0);
                map[i].put(diff, sum + origin + 1);
                ans += sum;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = { 2, 4, 6, 8, 10, 12 };
        num446 s = new num446();
        System.out.println(s.numberOfArithmeticSlices(A));
    }
}
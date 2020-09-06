package leetcode.sougo;

public class Solution2 {
    public static int getHouses(int t, int[] xa) {
        int count = 2;
        for (int i = 0; i < xa.length - 3; i += 2) {
            float first = xa[i] + (float) xa[i + 1] / 2;
            float second = xa[i + 2] - (float) xa[i + 3] / 2;
            float gap = second - first;
            if (gap < t)
                continue;
            if (gap > t)
                count += 2;
            if (gap == t)
                count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int t = 2;
        int[] xa = { -1, 4, 5, 2 };
        int result = getHouses(t, xa);
        System.out.println(result);
    }
}

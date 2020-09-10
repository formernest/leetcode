package leetcode;

import java.util.Arrays;

class num57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int[][] result = new int[m + 1][2];
        int start = newInterval[0];
        int end = newInterval[1];
        int index = 0;
        while (index < m) {
            if (intervals[index][1] < start) {
                result[index] = intervals[index];
                index++;
            } else {
                break;
            }
        }
        int i = index;
        while (i < m) {
            if (start <= intervals[i][1] && end >= intervals[i][0]) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
                i += 1;
            } else {
                break;
            }
        }
        result[index][0] = start;
        result[index][1] = end;
        index += 1;
        while (i < m) {
            result[index++] = intervals[i++];
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args) {
        num57 solution = new num57();
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] result = solution.insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
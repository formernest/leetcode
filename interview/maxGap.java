package interview;

/**
 * [程序员面试]:数组排序后相邻数的最大差值 
 * 思路：桶排序，找出数组中的最大值和最小值，使用len+1个桶，必有一个桶为空.
 * 统计每个桶中的最大值和最小值，最大差值一定为不相邻桶中的最小值和最大值的差值。
 */
public class maxGap {
    public int maxgap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (max == min)
            return 0;
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNum[i] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[i] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[i] = true;
        }
        int gap = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < len; i++) {
            if (hasNum[i]) {
                gap = Math.max(gap, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return gap;
    }

    private int bucket(int num, int len, int min, int max) {
        return (int) ((num - min) * len / (max - min));
    }
}

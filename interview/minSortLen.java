package interview;

/**
 * [程序员面试]：需要排序的最短子数组长度 
 * 从左到右遍历，找到需要排序的右边界，找到最小值，最小值左边即为没有再正确位置上需要排序的数组
 * 从右到左遍历，找到需要排序的左边界，记录最大值，最大值右边就是没有在正确位置上需要排序的值
 * 
 */
public class minSortLen {
    public int getMinLength(int[] arr, int k) {
        int noMinLeft = -1;
        int min = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > min) {
                noMinLeft = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        int max = arr[0];
        int noMaxRight = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                noMaxRight = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxRight - noMinLeft + 1;
    }
}

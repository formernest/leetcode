package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * [程序员面试]：未排序数组中累加和为给定值的最长子数组系列问题
 */
public class sumZeroProblem {
    /**
     * 全部为正数的子数组相加和为k的最长子数组长度
     * 
     * @param arr
     * @param k
     * @return
     */
    public static int longSub(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right += 1;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }

    /**
     * 可正可负或者为0的数组中元素和为k的最长子数组 使用map记录arr[0..i]中出现和为sum的最小位置，如果sum-k出现过，则计算最长位置
     * 
     * @param arr
     * @param k
     * @return
     */
    public static int longSub1(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 重要，如果所有元素相加和为k, 不然不会计算len值
        map.put(0, -1);
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k) + 1);
            }
            if (map.containsKey(sum))
                continue;
            map.put(sum, i);
        }
        return len;
    }

    /**
     * 可正可负可0元素中，正数和负数相等的最长子数组长度
     * 
     * @param arr
     * @return
     */
    public static int longSub2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                arr[i] = -1;
            if (arr[i] > 0)
                arr[i] = 1;
        }
        int len = longSub1(arr, 0);
        return len;
    }

    /**
     * 只有0和1的数组中，元素和为0的最长子数组的长度
     * 
     * @param arr
     * @return
     */
    public static int longSub3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = -1;
        }
        int len = longSub1(arr, 0);
        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 1 };
        int k = 3;
        int result = longSub(arr, k);
        System.out.println(result);
    }
}

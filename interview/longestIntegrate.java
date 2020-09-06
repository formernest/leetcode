package interview;

import java.util.HashSet;
import java.util.Set;
/**
 * [程序员面试]：最长的可整合子数组的长度
 * 如果一段数组可以整合：则必然这段数组非重复，并且最大值减最小的值等于数组的长度。
 */
public class longestIntegrate {
    public int getLenght(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if (max - min == j - i) {
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }
}

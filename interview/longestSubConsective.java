package interview;

/**
 * 程序员面试：数组中最长连续序列
 */
import java.util.HashMap;
import java.util.Map;

public class longestSubConsective {
    public static int getMax(int[] arr) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int left = map.getOrDefault(arr[i] - 1, 0);
            int right = map.getOrDefault(arr[i] + 1, 0);
            int count = left + right + 1;
            map.put(arr[i] - left, count);
            map.put(arr[i] + right, count);
            map.put(arr[i], count);
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        System.out.println(getMax(arr));
    }
}
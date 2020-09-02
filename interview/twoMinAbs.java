package interview;

import java.util.Arrays;

/*
微软：求两个数之和的绝对值最小值
思路：排序+相邻两数相加
 */
public class twoMinAbs {
    public int minAbs(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            min = Math.min(min, sum);
        }
        return min;
    }
}
package daily_problem;
/**
 * leetcode41  缺失的第一个正数
 * 对于长度为N的数组，缺失的元素在[1, N+1]中
 * 将所有在[1, N+1]范围之外的元素标记为(N+1)，将所有在范围内的元素标记为所属位置为负数。
 * 遍历数组，获得第一个大于0的元素的下标。
 */
public class day6_26 {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i=0; i<len; i++) {
            int cur = Math.abs(nums[i]);
            if (cur <= len) {
                nums[cur-1] = -Math.abs(nums[cur-1]);
            }
        }
        for (int i=0; i<len; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return len+1;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int result = firstMissingPositive(nums);
        System.out.println(result);
    }
}
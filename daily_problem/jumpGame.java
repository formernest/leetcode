package daily_problem;
/**
 * 跳跃游戏
 * 遍历数组，记录当前可以到达位置的最大值，如果当前位置大于可达位置的最大值，说明到达不了。
 */
public class jumpGame {
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int length = nums.length;
        int pos = 0;
        int end_max = pos + nums[pos];
        for(int i=1; i<length; i++){
            if(i>end_max) return false;
            end_max = Math.max(end_max, i+nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
       int[] nums = {3,2,1,0,4};
       System.out.println(canJump(nums));
    }
}
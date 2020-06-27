package daily_problem;

public class day5_1 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] + nums[i-1] > nums[i]){
                nums[i] += nums[i-1];
            }
            max = nums[i]>max? nums[i]:max;
        }
        return max;
    }
}
import java.util.Arrays;

class num41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len == 0 || nums[0] > 1 || nums[len-1] < 0) return 1;
        for(int i=0; i<len-1; i++){
            if(nums[i+1]-nums[i] > 1 && nums[i] >= 0) return nums[i]+1;
        }
        return nums[len-1] + 1;
    }
    public static void main(String[] args) {
        int[] nums = {};
        num41 solution = new num41();
        System.out.println(solution.firstMissingPositive(nums));
    }
}
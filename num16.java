import java.util.Arrays;
import java.lang.Math;
class num16{
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if(nums.length <= 3){
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
            }
            return sum;
        }
        Arrays.sort(nums);
        int i = 0;
        int closestSum = Integer.MAX_VALUE;
        while(i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum > target) while(nums[k--] == nums[k] && j < k);
                if(sum < target) while(nums[j] == nums[++j] && j < k);
                if(Math.abs(sum-target)< Math.abs(closestSum-target)){
                    closestSum = sum;
                } 
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return closestSum;
    }
    public static void main(String[] args) {
        num16 s = new num16();
        int[] array = new int[]{1, 1, 1, 1};
        System.out.println(s.threeSumClosest(array, 0));
    }
}
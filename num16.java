import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;
class num16{
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int min = 999;
        int sum = 0;
        // List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 3){
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
            }
            return sum;
        }
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum-target)<min) {min=Math.abs(sum-target);result = sum;}
                if(Math.abs(sum-target)<min) while(nums[j] == nums[++j] && j < k);
                if(Math.abs(sum-target)>min) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
    }
    public static void main(String[] args) {
        num16 s = new num16();
        int[] array = new int[]{-1, 2, 1, -4};
        System.out.println(s.threeSumClosest(array, 1));
    }
}
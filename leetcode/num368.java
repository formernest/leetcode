import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1; i<nums.length; i++){
            end = i;
            for(int j=i-1; j>=0; j--){
                if(nums[i] % nums[j] != 0){
                    break;
                }
            }
        }
    }
}
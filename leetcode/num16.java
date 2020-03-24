import java.util.Arrays;
import java.lang.Math;
class num16{
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
            int head=i+1, end=nums.length-1;
            while(head < end) {
                int sum = nums[i] + nums[head] + nums[end];
                if(Math.abs(sum-target)<min){
                    closestSum = sum;
                    min = Math.abs(sum-target);
                }
                if(sum > target) end--;
                else if(sum < target) head++;
                else return target;   
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        num16 s = new num16();
        int[] array = new int[]{1, 1, 1, 0};
        System.out.println(s.threeSumClosest(array, -100));
    }
}
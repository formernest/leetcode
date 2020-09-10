package leetcode;

class num713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for(int right=0; right< nums.length; right++){
            prod *= nums[right];
            while(prod >= k) prod /= nums[left++];
            ans += right-left+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        num713 s = new num713();
        int[] nums = {10, 5, 2, 6};
        int  k = 100;
        int result = s.numSubarrayProductLessThanK(nums, k);
        System.out.println(result);

    }
}
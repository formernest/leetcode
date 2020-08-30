package leetcode;

class num31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // [i+1, nums.length-1]为递减数组
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int i) {
        int end = nums.length - 1;
        while (i <= end) {
            swap(nums, i, end);
            i++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
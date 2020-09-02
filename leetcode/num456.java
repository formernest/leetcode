package leetcode;

class num456 {
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            while (j < nums.length - 1 && nums[j] <= nums[i])
                j++;
            while (j < nums.length - 1) {
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[j] > nums[k] && nums[k] > nums[i]) {
                        return true;
                    }
                    k--;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        num456 s = new num456();
        int[] nums = { -2, 1, 2, -2, 1, 2 };
        boolean result = s.find132pattern(nums);
        System.out.println(result);
    }
}
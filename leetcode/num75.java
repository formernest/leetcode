package leetcode;

class num75 {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[red];
                nums[red] = tmp;
                red += 1;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = tmp;
                i -= 1;
                blue -= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        num75 solution = new num75();
        solution.sortColors(nums);
        for (int item : nums) {
            System.out.println(item);
        }
    }
}
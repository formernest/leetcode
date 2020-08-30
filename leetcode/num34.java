package leetcode;

class num34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        boolean find = false;
        while (low <= high) {
            if (nums[mid] == target) {
                find = true;
                break;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        if (find) {
            int start = mid, end = mid;
            while (start - 1 >= 0 && nums[start - 1] == nums[mid])
                start--;
            while (end + 1 < nums.length && nums[end + 1] == nums[mid])
                end++;
            result[0] = start;
            result[1] = end;
        }
        return result;
    }

    public static void main(String[] args) {
        num34 s = new num34();
        int[] nums = new int[] { 1 };
        int target = 1;
        int[] result = s.searchRange(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
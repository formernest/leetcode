package leetcode;

class num33 {
    // public int search(int[] nums, int target) {
    // if(nums.length == 0) return -1;
    // if(target >= nums[0]){
    // for(int i=0;i<nums.length&&nums[i]>=nums[0];i++){
    // if(nums[i] == target) return i;
    // }
    // }else{
    // for(int i=nums.length-1; i>=0&&nums[i]<=nums[nums.length-1]; i--){
    // if(nums[i] == target) return i;
    // }
    // }
    // return -1;
    // }
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        num33 s = new num33();
        int[] nums = new int[] { 1 };
        int target = 2;
        System.out.println(s.search(nums, target));
    }
}
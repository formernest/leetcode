package daily_problem;
/**
 * 搜索旋转数组
 */
public class num33 {
    public static int search(int[] nums, int target) {
        int start = 0;
        int n = nums.length-1;
        int end = n;
        if(nums.length == 0 || (nums.length == 1 && nums[0] != target)) return -1;
        if(target < nums[start] && target > nums[end]) return -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target) return mid;
            // 先通过mid和开头结尾的位置判断有序区间，然后再有序区间中查找
            if(nums[mid] >= nums[0]){
                if(nums[mid] > target && nums[0] <= target){
                    end = mid - 1;  
                }else{
                    start = mid + 1;
                }   
            }else{
                if(nums[mid] < target && nums[n] >= target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int target = 3;
        int[] nums = {4,5,6,7,0,1,2};
        int result = search(nums, target);
        System.out.println(result);
    }
}
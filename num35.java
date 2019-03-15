class num35{
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int result = 0;
        boolean falg = true;
        while(falg){
            mid = (low+high)/2;
            if((target > nums[mid] && mid == nums.length-1)||(target > nums[mid] && target <= nums[mid+1])){
                falg = false;
                result =  mid+1;
            }else if(target <= nums[mid] && mid == 0){
                falg = false;
                result = 0;
            }else if(target < nums[mid]){
                high = mid - 1;
                mid = (low+mid)/2;
            }else{
                low = mid + 1;
                mid = (low+high)/2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        num35 s = new num35();
        int []nums = {1,3,5,6};
        System.out.println(s.searchInsert(nums, 7));
    }
}
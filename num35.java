class num35{
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
    public static void main(String[] args) {
        num35 s = new num35();
        int []nums = {1,3,5,6};
        System.out.println(s.searchInsert(nums, 7));
    }
}
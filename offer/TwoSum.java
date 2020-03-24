class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j< nums.length; j++){
                if(nums[j] == target-nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        TwoSum s = new TwoSum();
        int[] result = s.twoSum(nums, 9);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
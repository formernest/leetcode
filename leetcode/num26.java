class num26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int current = nums[0];
        int length = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==current) continue;
            else{
                current = nums[i];
                length += 1;
                nums[length-1] = current;
            }
        }
        return length;
    }
    public static void main(String[] args) {
        num26 s = new num26();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(s.removeDuplicates(nums));
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
class num300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 1;
        int[] memory = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            memory[i] = 1;
        }
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    memory[i] = Math.max(memory[j]+1, memory[i]);
                    max = Math.max(memory[i], max);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        num300 s = new num300();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(s.lengthOfLIS(nums));
    }
}
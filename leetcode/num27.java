class num27 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                length++;
            }else{
                nums[i-length] = nums[i];
            }
        }
        return nums.length-length;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        num27 s = new num27();
        int result = s.removeElement(nums, val);
        System.out.println("result:"+result);
        for(int i=0; i<result; i++){
            System.out.println(nums[i]);
        }
    }
}
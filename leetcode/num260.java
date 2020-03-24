class num260 {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for(int num:nums) sum ^= num;
        int[] res = new int[2];
        sum &= -sum;
        for(int num:nums){
            if((sum & num) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
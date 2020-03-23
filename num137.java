class Solution {
    public int singleNumber(int[] nums) {
        int[] bitnum = new int[32];
        int res = 1;
        int k = 3;
        for(int n:nums){
            int bit = 1;
            for(int i=0; i<32; i++){
                if((bit&n) == 1){
                    bitnum[i] += 1;
                }
                bit = bit << 1;
            }
        }
        for(int i=31; i>=0; i--){
            res = res << 1;
            res += bitnum[i] % k;
        }
        return res;
    }
}
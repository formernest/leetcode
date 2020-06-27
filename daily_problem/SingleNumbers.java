package daily_problem;
/**
 * 找到两个只出现一次的数
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for(int item:nums){
            sum ^= item;
        }
        int[] result = new int[2];
        int flag = 1;
        while((sum & flag) == 0) flag <<= 1;
        for(int item:nums){
            if((item & flag) == 0) result[0]^=item;
            else result[1]^=item;
        }
        return result;
    }
}
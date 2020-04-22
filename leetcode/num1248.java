package leetcode;
/**
 * 统计优美子数组
 * 子数组中奇数的个数为k
 */
public class num1248{
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return 0;
        int n=nums.length;
        int[] odds=new int[n+2];
        int ans=0;
        int count=0;
        // 获得所有的奇数的位置
        for(int i=0; i<n; i++){
            if(nums[i]%2==1) odds[++count]=i;
        }
        //存放边界
        odds[0]=-1; 
        odds[++count]=n;
        //计算所有奇数为k的子数组的数量
        for(int i=1; i+k<=count; i++){
            ans+=(odds[i]-odds[i-1])*(odds[i+k]-odds[i+k-1]);
        }
        return ans;
    }
}
package interview;
/**
 * 程序员面试：跳跃游戏
 * 
 */
public class jumpGame {
    public static int minJump(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for(int i=0; i<nums.length; i++){
            if(cur < i){
                jump ++;
                cur = next;
            }
            next = Math.max(next, i+nums[i]);
        }
        return jump;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 1, 4};
        System.out.println(minJump(nums));
    }
}
package daily_problem;

public class day5_4 {
    public int jump(int[] nums) {
        int max_pos = 0;
        int length = nums.length;
        int end = 0;
        int step = 0;
        for(int i=0; i<length-1; i++){
            max_pos = Math.max(max_pos, i+nums[i]);
            if(i == end){
                end = max_pos;
                step += 1;
            }
        }
        return step;
    }
}
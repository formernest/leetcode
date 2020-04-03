package leetcode;
/**
 * 有重复元素的排列组合
 * 回溯法
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class num47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        Arrays.sort(nums);
        permute(res, temp, nums, use);
        return res;
    }
    public void permute(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] use){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }
        for(int i=0; i<nums.length; i++){
            if(!use[i]){
                if(i==0 || nums[i-1] != nums[i] || use[i-1]){
                    temp.add(nums[i]);
                    use[i] = true;
                    permute(res, temp, nums, use);
                    temp.remove(temp.size()-1);
                    use[i] = false;
                }
            }
        }
    }
}
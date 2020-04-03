package leetcode;
import java.util.ArrayList;
import java.util.List;
public class num46{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=0; i<=temp.size(); i++){
                temp.add(i, nums[temp.size()]);
                backtrack(res, temp, nums);
                temp.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        num46 solution = new num46();
        List<List<Integer>> result = solution.permute(nums);
        for(List<Integer> list:result){
            for(Integer item:list){
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }
}
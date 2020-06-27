package daily_problem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int num:nums) temp.add(num);
        int length = nums.length;
        backTrack(res, temp, length, 0);
        return res;
    }
    public void backTrack(List<List<Integer>> res, List<Integer> temp, int length, int first){
        if(first == length) res.add(new ArrayList<>(temp));
        for(int i=first; i<length; i++){
            Collections.swap(temp, i, first);
            backTrack(res, temp, length, first+1);
            Collections.swap(temp, i, first);
        }
    }
}
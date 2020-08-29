package leetcode;

import java.util.LinkedList;
import java.util.List;

public class num491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i=0; i<nums.length; i++){
            int current = nums[i];
            LinkedList<Integer> temp = new LinkedList<>();
            temp.addFirst(current);
            for (int j=i-1; j>=0; j--) {
                if (nums[j] <= current) {
                    result.add(temp);
                    temp.addFirst(nums[j]);
                    current = nums[j];
                }
            }
            result.add(temp);
        }
        return result;
    }
}
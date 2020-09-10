package leetcode;
/**
 * 组合总和
 * dfs + 回溯
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int sum, int cur, List<Integer> temp) {
        if (sum == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum < 0)
            return;
        for (int i = cur; i < candidates.length; i++) {
            if (i > cur && candidates[i] == candidates[i - 1])
                continue;
            temp.add(candidates[i]);
            dfs(result, candidates, sum - candidates[i], i + 1, temp);
            temp.remove(temp.size() - 1);
        }

    }
}

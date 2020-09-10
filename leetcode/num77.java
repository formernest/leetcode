package leetcode;

import java.util.ArrayList;
import java.util.List;

public class num77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        dfs(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int current, int n, int k) {
        if (temp.size() + (n - current + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(current);
        dfs(result, temp, current + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(result, temp, current + 1, n, k);
    }

    public static void main(String[] args) {
        num77 solution = new num77();
        
    }
}

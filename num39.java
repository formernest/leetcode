import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class num39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> list, int[] cand, int remain, int from) {
        if (remain < 0) { return; }
        if (remain == 0) { ans.add(new ArrayList<Integer>(list)); return; }
        for (int i=from; i<cand.length; ++i) {  //cand[] sorted; from is the starting point of picking elements at this level
            list.add(cand[i]);
            dfs(ans, list, cand, remain-cand[i], i);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        num39 s = new num39();
        List<List<Integer>> result = new ArrayList<>();
        result = s.combinationSum(candidates, target);
        for(int i=0; i< result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}
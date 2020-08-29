package leetcode;

import java.util.HashSet;
import java.util.Set;

public class num753 {
    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1)
            return "0";
        Set<String> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append("0");
        }
        String start = sb.toString();
        dfs(start, k, set, ans);
        ans.append(start);
        return new String(ans);
    }

    private void dfs(String start, int k, Set<String> set, StringBuilder ans) {
        for (int i = 0; i < k; i++) {
            String nei = start + i;
            if (!set.contains(nei)) {
                set.add(nei);
                dfs(nei.substring(1), k, set, ans);
                ans.append(i);
            }
        }
    }

}
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class num139 {
    public boolean wordBreak(String s, ArrayList<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        num139 solution = new num139();
        String s = "leetcode";
        System.out.println(s.substring(0, 2));
        ArrayList<String> wordDict = new ArrayList<String>(Arrays.asList("leet", "code"));
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println(result);
    }
}
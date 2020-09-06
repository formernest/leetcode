package leetcode;

import java.util.ArrayList;
import java.util.List;

class num22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            if (valid(cur))
                ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < max)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    public boolean valid(String cur) {
        int balance = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return (balance == 0);
    }

    public static void main(String[] args) {
        num22 s = new num22();
        List<String> ans = s.generateParenthesis(3);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
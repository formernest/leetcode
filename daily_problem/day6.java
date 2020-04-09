package daily_problem;
/**
 * 括号生成
 */
import java.util.LinkedList;
import java.util.List;

public class day6 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        generate(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    public static void generate(List<String> ans, StringBuilder sb, int open, int close, int max){
        if(sb.length() == 2 * max){
            ans.add(new String(sb));
            return;
        }
        if(open < max){
            sb.append('(');
            generate(ans, sb, open+1, close, max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(')');
            generate(ans, sb, open, close+1, max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

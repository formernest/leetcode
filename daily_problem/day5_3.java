package daily_problem;

import java.util.HashSet;
import java.util.Set;

public class day5_3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || "".equals(s)) return 0;
        int n = s.length();
        int rk = -1;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<n; i++){
            if(i!=0) set.remove(s.charAt(i-1));
            while(rk+1<n && !set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                rk += 1;
            }
            ans = Math.max(ans, rk-i+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
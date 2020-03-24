import java.util.HashMap;
import java.util.Map;
class LongestStr {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character 
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestStr l = new LongestStr();
        String s = "dvdf";
        int length = l.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}

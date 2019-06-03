import java.util.HashMap;
import java.util.Map;

class num76{
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)  return "";
        Map<Character, Integer> dict = new HashMap<Character,Integer>();
        for(int i=0; i<t.length(); i++){
            int count = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), count+1);
        }
        int required = dict.size();
        int formed = 0;
        int l=0, r =0;
        Map<Character, Integer> windowCount = new HashMap<Character, Integer>();
        int[] ans={-1,0,0};
        while(r<s.length()){
            char c = s.charAt(r);
            int count = windowCount.getOrDefault(c, 0);
            windowCount.put(c, count+1);
            if(dict.containsKey(c) && dict.get(c)==windowCount.get(c)){
                formed ++;
            }
            while(l<r && formed==required){
                c = s.charAt(l);
                if(ans[0]==-1||r-l+1<ans[0]){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCount.put(c,windowCount.get(c)-1);
                if(dict.containsKey(c) && windowCount.get(c) < dict.get(c)) formed--;
                l++;
            }
            r++;
        }
        return ans[0]==-1? "" : s.substring(ans[1], ans[2]+1);
    }
    public static void main(String[] args) {
        num76 s = new num76();
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String result= s.minWindow(S, T);
        System.out.println(result);
    }
}
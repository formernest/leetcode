package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 统计重复个数
 */
public class num466 {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1 == 0) return 0;
        int c1=0, c2=0, index=0;
        Map<Integer, int[]> map = new HashMap<>();
        int[] pre;
        int[] in;
        while(true){
            c1 += 1;
            for(int i=0; i<s1.length(); i++){
                if(s2.charAt(index) == s1.charAt(i)){
                    index += 1;
                    if(index == s2.length()){
                        c2 += 1;
                        index = 0;
                    }
                }
            }
            if(c1 == n1) return c2/n2;
            if(map.containsKey(index)){
                pre = map.get(index);
                in = new int[]{c1-pre[0], c2-pre[1]};
                break;
            }else{
                map.put(index, new int[]{c1, c2});
            }
        }
        int ans = pre[1] + (n1-pre[0])/in[0]*in[1];
        int rest = (n1-pre[0])%in[0];
        while(rest-->0){
            for(int i=0; i<s1.length(); i++){
                if(s1.charAt(i) == s2.charAt(index)){
                    index += 1;
                    if(index == s2.length()){
                        ans += 1;
                        index = 0;
                    }
                }
            }
        }
        return ans/n2;
    }
    public static void main(String[] args) {
        String s1 = "baba";
        int n1 = 11;
        String s2 = "baab";
        int n2 = 1;
        int result = getMaxRepetitions(s1, n1, s2, n2);
        System.out.println(result);
    }
}
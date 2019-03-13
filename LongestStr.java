import java.util.HashMap;
import java.util.Map;
class LongestStr {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int maxlength = 0;
        char c;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);      
            if(map.containsKey(c)){
                map.clear();
                if (length > maxlength){
                    maxlength = length;
                }
                length = 0;
            }     
            map.put(c, 1);
            length ++;           
        }
        if(length > maxlength){
            maxlength = length;
        }
        return maxlength;
    }
    public static void main(String[] args) {
        LongestStr l = new LongestStr();
        String s = "dvdf";
        int length = l.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}

package leetcode.bilibili;

public class Solution3 {
    public int GetFragment (String str) {
        int index = 1;
        int count = 1;
        while(index < str.length()){
            if(str.charAt(index) != str.charAt(index-1)) {
                count += 1;
            }
            index += 1;
        }
        return str.length()/count;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(result, map, digits, 0, new StringBuffer());
        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> map, String digits, int index,
            StringBuffer stringBuffer) {
        if (stringBuffer.length() == digits.length()) {
            result.add(stringBuffer.toString());
        }else{
            String temp = map.get(digits.charAt(index));
            for (int i=0; i<temp.length(); i++) {
                stringBuffer.append(temp.charAt(i));
                backtrack(result, map, digits, index+1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }
}
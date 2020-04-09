package leetcode;
/**
 * 去除重复字母
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class num316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(!set.contains(c)){
                while(!stack.empty() && stack.peek() > c && map.get(stack.peek()) > i){
                    set.remove(stack.pop());
                }
                stack.push(s.charAt(i));
                set.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}
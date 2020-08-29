package leetcode;

import java.util.Stack;
/**
 * 有效的括号
 */
public class num20 {
    public static boolean isValid(String s) {
        if("".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if (c == ')' && (stack.isEmpty() || stack.peek() != '(')) {
                return false;
            }else if (c == ']' && (stack.isEmpty() || stack.peek() != '[')) {
                return false;
            }else if (c == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty()? true : false;
    }
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
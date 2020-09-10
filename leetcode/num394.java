package leetcode;

import java.util.Stack;

class num394 {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<StringBuilder> sbStack = new Stack<>();
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                intStack.push(k);
                sbStack.push(sb);
                k = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = sb;
                sb = sbStack.pop();
                for (int i = intStack.pop(); i > 0; i--) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        num394 solution = new num394();
        System.out.println(solution.decodeString(s));
    }
}
package interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution5 {
    public static void main(String[] args) {

    }

    public List<Integer> add(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int item : l1) {
            stack1.push(item);
        }
        for (int item : l2) {
            stack2.push(item);
        }
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty()? 0 : stack1.pop();
            int num2 = stack2.isEmpty()? 0 : stack2.pop();
            sum = num1 + num2;
            sum += carry;
            int current = sum % 10;
            carry = sum / 10;
            list.addFirst(current);
        }
        // Stack<Integer> stack = stack1.isEmpty() ? stack2 : stack1;
        // while (!stack.isEmpty()) {
        //     sum = stack.pop();
        //     sum += carry;
        //     int current = sum % 10;
        //     carry = sum / 10;
        //     list.addFirst(current);
        // }
        if (carry > 0)
            list.addFirst(carry);
        return list;
    }
}

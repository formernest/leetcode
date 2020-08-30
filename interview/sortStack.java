package interview;

import java.util.Stack;

/*
用一个栈实现另一个栈的排序
使用辅助栈结构实现栈的排序
stack作为pop栈，对于弹出的栈顶元素和help栈中的栈顶元素进行比较
    1、如果栈顶元素的值大于help的栈顶元素，则将help栈的元素一次压入弹出栈中
    2、否则直接将栈顶元素压入help栈中
*/
public class sortStack {
    public void sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.add(help.pop());
        }
    }

    public static void main(String[] args) {
        int[] nums = { 5, 9, 6, 3, 1 };
        Stack<Integer> stack = new Stack<Integer>();
        for (int num : nums) {
            stack.push(num);
        }
        sortStack solution = new sortStack();
        solution.sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
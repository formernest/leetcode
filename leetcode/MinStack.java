package leetcode;
/**
 * num155
 * 最小栈
 */
import java.util.Stack;

public class MinStack {
    Stack<Integer> pushStack = null;
    Stack<Integer> minStack = null;

    public MinStack() {
        this.pushStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
        if (!minStack.empty()) {
            minStack.push(x < minStack.peek()? x : minStack.peek());
        }else{
            minStack.push(x);
        }
    }

    public void pop() {
        pushStack.pop();
        minStack.pop();
    }

    public int top() {
        return pushStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
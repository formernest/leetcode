package leetcode;

import java.util.Stack;

public class MyQueue {
    /** Initialize your data structure here. */
    Stack<Integer> push;
    Stack<Integer> pop;
    public MyQueue() {
        push = new Stack<>();
        pop = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        push.push(x);
        if (pop.isEmpty()) {
            while (!push.empty()){
                pop.push(push.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return pop.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return pop.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return push.empty() && pop.empty();
    }
}
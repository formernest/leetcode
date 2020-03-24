import java.util.Stack;
// 用两个栈实现队列
public class offer4 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int item = stack1.pop();
                stack2.push(item);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        offer4 solution = new offer4();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        for(int i=0; i<4; i++){
            System.out.println(solution.pop());
        }
    }
}
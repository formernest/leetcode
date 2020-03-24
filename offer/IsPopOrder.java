import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == popA.length && popA.length == 0){
            return true;
        }
        if(pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int i=0, j=0;
        stack.push(pushA[i++]);
        while(j <= popA.length-1){
            while(popA[j] != stack.peek()){
                if(i == pushA.length) return false;
                stack.push(pushA[i++]);
            }
            j++;
            stack.pop();
        }
        return true;
    }
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        IsPopOrder solution = new IsPopOrder();
        System.out.println(solution.IsPopOrder(pushA, popA));
    }
}
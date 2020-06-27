package others;

import java.util.Scanner;
import java.util.Stack;

public class ten4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        TwoStacksQueue queue = new TwoStacksQueue();
        for(int i=0; i<n; i++){
            String items[] = scanner.nextLine().split(" ");
            String op = items[0];
            if(op.equals("peek")){
                int result = queue.peek();
                System.out.println(result);
            }
            if(op.equals("poll")) queue.poll();
            if(op.equals("add")){
                int num = Integer.parseInt(items[1]);
                queue.add(num);
            }
        }
    }
}

class TwoStacksQueue{
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    private void pushToPop(){
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int item){
        stackPush.push(item);
        pushToPop();
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            return -1;
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            return -1;
        }
        pushToPop();;
        return stackPop.peek();
    }
}
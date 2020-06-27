package others;

import java.util.LinkedList;
import java.util.Scanner;


public class ten1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            int m = scanner.nextInt();
            scanner.nextLine();
            Queue queue = new Queue();
            while(m-->0){
                String[] items = scanner.nextLine().split(" ");
                String op = items[0];
                if(op.equals("TOP")){
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.top());
                }else if(op.equals("POP")){
                    if(queue.pop() == -1) System.out.println(-1);
                }else if(op.equals("PUSH")){
                    int num = Integer.parseInt(items[1]);
                    queue.push(num);
                }else if(op.equals("SIZE")){
                    System.out.println(queue.size());
                }else if(op.equals("CLEAR")) queue.clear();
            }
        }
    }
}

class Queue{
    LinkedList<Integer> queue = new LinkedList<>();
    public void push(int item){
        queue.add(item);
    }
    public int top(){
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peekFirst();
    }
    public int pop(){
        if(queue.isEmpty()) return -1;
        return queue.pollFirst();
    }
    public int size(){
        return queue.size();
    }
    public void clear(){
        queue = new LinkedList<>();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
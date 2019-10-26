import java.util.ArrayList;
import java.util.LinkedList;

public class offer9 {
    // 滑动窗口的最大值
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> array = new ArrayList<>();
        if(size ==0 || num.length<size) return array;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<num.length; i++){
            if(!queue.isEmpty() && queue.peek() == i-size) queue.removeFirst();
            while(!queue.isEmpty() && num[queue.getLast()] < num[i]) queue.removeLast();
            queue.add(i);
            if(i>=size-1)   array.add(num[queue.peek()]);
        }
        return array;
    }
}
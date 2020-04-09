package interview;

import java.util.PriorityQueue;

/**
 * 程序员面试：分金条的最小花费
 */
public class minSplitCoat {
    public static int getMin(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        // 使用最小堆存储将被分割成的长度
        PriorityQueue<Integer> minCost = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            minCost.offer(arr[i]);
        }
        int sum = 0;
        // 知道最后剩下的元素为1个
        while(minCost.size()!=1){
            int current = minCost.poll() + minCost.poll();
            minCost.offer(current);
            sum += current;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {10, 30, 20};
        System.out.println(getMin(arr));
    }
}
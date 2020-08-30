package interview;

import java.util.Stack;

/*
给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置相应的信息
arr = [3,4,1,5,6,2,7]
返回 
[[-1,2],[0,2],[-1,-1],[2,5],[3,5],[2,-1],[5,-1]]
解题：单调栈
栈中存储从栈底到栈顶的递增序列，这样对于一个元素左边的最小元素就是栈中的相邻元素，右边的即为当前符合条件的值。
*/
public class MonotonousStack {
    public int[][] monotonousStack(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, 5, 6, 2, 7 };
        MonotonousStack solution = new MonotonousStack();
        int[][] res = solution.monotonousStack(arr);
        for (int[] items : res) {
            System.out.println(items[0]);
            System.out.println(items[1]);
        }
    }
}
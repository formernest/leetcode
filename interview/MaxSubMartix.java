package interview;

import java.util.Stack;

/*
求最大子矩阵的大小
使用分层直方图的方式
*/
public class MaxSubMartix{
    public int getMax(int[][] matrix){
        int levers = matrix.length;
        if(levers == 0) return 0;
        int cols = matrix[0].length;
        int[] height = new int[cols+1];
        int max = 0;
        for(int i=0; i<levers; i++){
            for(int j=0; j<cols; j++){
                height[j] = matrix[i][j] == 0? 0:height[j] + 1;
            }
            int levelmax = calLeve1(height);
            max = levelmax > max? levelmax:max;
        }
        return max;
    }
    /*
    使用普通方式
    */
    public int calLeve(int[] height){
        int max = 0;
        for(int i=0; i<height.length-1; i++){
            if(height[i] > height[i+1]){
                int minheight = height[i];
                for(int j=i; j>=0; j--){
                    minheight = minheight > height[j]? height[j]:minheight;
                    int curArea = minheight * (i-j+1);
                    max = max>curArea? max:curArea;
                }
            }
        }
        return max;
    }
    /*
    使用单调栈方式
    */
    public int calLeve1(int[] height){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0; i<height.length-1; i++){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                int j = stack.pop();
                int pre = stack.isEmpty()? -1:stack.peek();
                int cur = (i-pre-1)*height[j];
                max = cur>max? cur:max;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int pre = stack.isEmpty()? -1:stack.peek();
            int cur = (height.length-1-pre-1)*height[j];
            max = cur>max? cur:max;
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        MaxSubMartix solution = new MaxSubMartix();
        System.out.println(solution.getMax(matrix));
    }
    
}
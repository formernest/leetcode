package leetcode;
import java.util.Stack;

class num85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[] height = new int[n+1];
        height[n] = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    height[j] += 1;
                }else{
                    height[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    // public int largestRectangleArea(int[] height){
    //     int res = 0;
    //     for(int i=0; i<height.length; i++){
    //         if(i+1<height.length && height[i]<=height[i+1]) continue;
    //         int minH = height[i];
    //         for(int j=i; j>=0; j--){
    //             minH = Math.min(minH, height[j]);
    //             int temp = (i-j+1) * minH;
    //             res = Math.max(temp, res);
    //         }
    //     }
    //     return res;
    // }
    public int largestRectangleArea(int[] height){
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<height.length; ++i){
            while(!stack.empty()&&height[stack.peek()]>=height[i]){
                int cur = stack.pop();
                res = Math.max(res, height[cur] * (stack.empty()? i: i-stack.peek()-1));
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] matrix =
            {2, 1, 5, 6, 2, 3};
        num85 solution = new num85();
        System.out.println(solution.largestRectangleArea(matrix));
    }
}
package daily_problem;
/**
 * 盛水最多的容器
 */
class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int high = height.length-1;
        int low = 0;
        int max = Integer.MIN_VALUE;
        while(low < high){
            max = Math.max(max, Math.min(height[low], height[high])*(high-low));
            if(height[low]<height[high]) low++;
            else high--;
        }
        return max;
    }
}

public class maxArea {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,2,1};
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}
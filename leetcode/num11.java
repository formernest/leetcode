package leetcode;
/**
 * 盛最多水的容器
 */
class num11 {
    public int maxArea(int[] height) {
        int low = 0, high = height.length - 1, maxarea = 0;
        while (low < high) {
            maxarea = Math.max(maxarea, Math.min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        num11 s = new num11();
        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(s.maxArea(height));
    }
}
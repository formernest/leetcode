class num42 {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int ans = 0;
        int size = height.length;
        int[] max_left = new int[size];
        int[] max_right = new int[size];
        max_left[0] = height[0];
        for(int i=1; i<size; i++){
            max_left[i] = Math.max(height[i], max_left[i-1]);
        }
        max_right[size-1] = height[size-1];
        for(int i=size-2; i>=0; i--){
            max_right[i] = Math.max(height[i], max_right[i+1]);
        }
        for(int i=1; i<size; i++){
            ans += Math.min(max_left[i], max_right[i])-height[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        num42 solution = new num42();
        System.out.println(solution.trap(height));
    }
}
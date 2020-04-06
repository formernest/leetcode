package daily_problem;

public class day2 {
    public static int getTrap(int[] height){
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int result = 0;
        while(left<right){
            if(height[left] < height[right]){
                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    result += left_max - height[left];
                }
                left ++;
            }else{
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    result += right_max - height[right];
                }
                right --;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getTrap(height));
    }
}
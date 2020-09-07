package interview;

/**
 * [程序员面试]：容器盛水问题
 */
public class maxWater {
    public static int getWater(int[] arr) {
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int left = 1;
        int right = arr.length - 2;
        int sum = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, arr[left]);
                sum += leftMax - arr[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, arr[right]);
                sum += rightMax - arr[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 2, 4 };
        int result = getWater(arr);
        System.out.println(result);
    }
}

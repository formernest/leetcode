package interview;

/**
 * [程序员面试]：最长递增子序列
 */
public class longestGenLIS {
    // o(n^2)
    public static int getMax(int[] arr) {
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // o(nlogn), 二分查找
    public static int getDp2(int[] arr) {
        int[] dp = new int[arr.length];
        // ends[i]表示在i+1长度的序列中，最小的结尾数位ends[i]
        int[] ends = new int[arr.length];
        int right = 0;
        ends[0] = arr[0];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            int l = 0;
            int r = right;
            // 在ends中找到小于arr[i]的最大位置l
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr[i] > ends[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // l可能等于right+1
            right = Math.max(right, l);
            // 1、l=right+1 说明有效区内的位置都小于当前值，将right+1，
            // 2、l=其他 有效区内小于当前位置的，则更新相应位置;
            ends[l] = arr[i];
            // 获得当前位置dp值
            dp[i] = l+1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
        int result = getMax(arr);
        System.out.println(result);
        result = getDp2(arr);
        System.out.println(result);
    }
}
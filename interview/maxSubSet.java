package interview;

import java.util.HashMap;
import java.util.Map;

/*
给定一个数组，数组中只包含0和1。请找到一个最长的子序列，其中0和1的数量是相同的。
思路：使用动态规划的方法，保存[0,i]子序列的和
1、将序列中的所有数字0换为-1
2、如果得到的最大子序列是从头开始，则最大子序列的末尾dp值肯定是0，并且序列的长度为偶数。
1   0   1   0   1   0   1   0
0	1	2	3	4	5	6	7
1	0	1	0	1	0	1	0
3、如果得到的最大子序列不是从头开始，则最大子序列是所有dp值相同的子序列的最大长度。
1   1   0   1   1   0   0
0	1	2	3	4	5	6
1	2	1	2	3	2	1
*/
public class maxSubSet {
    public int getSum(String input) {
        int length = input.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = input.charAt(i) - '0';
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int max = 0;
        int[] dp = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (i == 0)
                dp[i] = arr[i];
            else
                dp[i] = dp[i - 1] + arr[i];
            if (!map.containsKey(dp[i])) {
                map.put(dp[i], i);
            }
            if (dp[i] == 0 && i % 2 == 1) {
                max = Math.max(max, i + 1);
            } else {
                max = Math.max(max, i - map.get(dp[i]));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String input = "1101000";
        maxSubSet solution = new maxSubSet();
        System.out.println(solution.getSum(input));
    }
}
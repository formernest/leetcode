package interview;

import java.util.Arrays;
import java.util.Comparator;
/**
 * [程序员面试]信封的最大嵌套数
 * 参考最长递增子序列
 * 排序：envelopes[i][0]递增，envelopes[i][0]相同则envelopes[i][1]递减
 * 原因：嵌套肯定是长度递增，envelopes[i][0]已排序，相同的长度下宽度逆序不用进行宽度的比较，那么只要考虑envelopes[i][1]的最长递增子序列就可以。
 */
public class maxEnvelopes {
    public static int getMax(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        // 在envelopes[i][1]中找最长递增子序列
        int[] dp = new int[envelopes.length];
        int[] ends = new int[envelopes.length];
        int right = 0;
        ends[0] = envelopes[0][1];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < envelopes.length; i++) {
            int l = 0;
            int r = right;
            while (l <= r) {
                int m = (l + r) / 2;
                if (envelopes[i][1] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = envelopes[i][1];
            dp[i] = l + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        
    }
}
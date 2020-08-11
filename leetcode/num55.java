package leetcode;

enum Index {
    Good, Bad, Unknown
}

public class num55 {
    Index[] memo;

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Index.Unknown;
        }
        memo[nums.length - 1] = Index.Good;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthest = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthest; j++) {
                if (memo[j] == Index.Good) {
                    memo[i] = Index.Good;
                    return true;
                }
            }
        }
        return memo[0] == Index.Good;
    }

    public boolean canJump1(int[] nums) {
        int right = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i <= right) {
                right = Math.max(right, i + nums[i]);
                if (right >= n - 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        num55 s = new num55();
        System.out.println(s.canJump1(nums));
    }
}
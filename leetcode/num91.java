package leetcode;

class num91 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.startsWith("0"))
            return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = dp[i - 1];
                } else {
                    return 0;
                }
            } else if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26
                    && Integer.parseInt(s.substring(i - 1, i + 1)) > 9) {
                if (i == 1)
                    dp[i] = dp[i - 1] + 1;
                else {
                    dp[i] = dp[i - 2] + dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        String s = "110";
        // System.out.println(s.substring(1,3));
        num91 solution = new num91();
        System.out.println(solution.numDecodings(s));
    }
}
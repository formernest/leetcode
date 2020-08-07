package leetcode;

class num264 {
    public int nthUglyNumber(int n) {
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int num2 = ugly[index2] * 2;
            int num3 = ugly[index3] * 3;
            int num5 = ugly[index5] * 5;
            ugly[i] = Math.min(num2, Math.min(num3, num5));
            if (ugly[i] == num2)
                index2++;
            if (ugly[i] == num3)
                index3++;
            if (ugly[i] == num5)
                index5++;
        }
        return ugly[n - 1];
    }
}
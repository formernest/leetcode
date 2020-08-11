package leetcode;

class num134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if (length <= 0)
            return -1;
        for (int i = 0; i < length; i++) {
            if (gas[i] >= cost[i]) {
                int result = gas[i] - cost[i];
                int k = i == length - 1 ? 0 : i + 1;
                while (k != i) {
                    result += gas[k] - cost[k];
                    if (result < 0)
                        break;
                    k++;
                    k = k == length ? 0 : k;
                }
                if (result < 0 || k != i)
                    continue;
                else
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = { 2 };
        int[] cost = { 2 };
        num134 s = new num134();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
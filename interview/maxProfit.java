package interview;

/**
 * 程序员面试：做项目的最大收益问题
 */
import java.util.Comparator;
import java.util.PriorityQueue;

class Program {
    int cost;
    int profit;

    public Program(int c, int p) {
        this.cost = c;
        this.profit = p;
    }
}

class minCostComp implements Comparator<Program> {
    @Override
    public int compare(Program o1, Program o2) {
        // TODO Auto-generated method stub
        return o1.cost - o2.cost;
    }
}

class maxProfitComp implements Comparator<Program> {
    @Override
    public int compare(Program o1, Program o2) {
        // TODO Auto-generated method stub
        return o2.profit - o1.profit;
    }
}

public class maxProfit {
    public static int getMax(int W, int K, int[] cost, int[] profit) {
        if (W < 1 || K < 0 || cost == null || profit == null || cost.length != profit.length) {
            return W;
        }
        // 使用小根堆存储项目的最小花费
        PriorityQueue<Program> minCost = new PriorityQueue<>(new minCostComp());
        // 使用大根堆存储项目的最大收益
        PriorityQueue<Program> maxProfit = new PriorityQueue<>(new maxProfitComp());
        for (int i = 0; i < cost.length; i++) {
            minCost.offer(new Program(cost[i], profit[i]));
        }
        while (K > 0) {
            // 将满足条件且花费最少的放入最大收益堆
            while (!minCost.isEmpty() && minCost.peek().cost <= W) {
                maxProfit.offer(minCost.poll());
            }
            // 不再有满足条件的项目
            if (maxProfit.isEmpty()) {
                return W;
            }
            // 获取最大收益的项目
            W += maxProfit.poll().profit;
            K--;
        }
        return W;
    }

    public static void main(String[] args) {
        int[] cost = { 5, 4, 1, 2 };
        int[] profit = { 3, 5, 3, 2 };
        int W = 3;
        int K = 2;
        int result = getMax(W, K, cost, profit);
        System.out.println(result);
    }
}
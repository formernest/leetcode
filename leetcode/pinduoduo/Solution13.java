package leetcode.pinduoduo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int init = scanner.nextInt();
        Thing[] arr = new Thing[num];
        for (int i=0; i<num; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[i] = new Thing(a, b);
        }
        PriorityQueue<Thing> costMin = new PriorityQueue<>(new Comparator<Thing>(){
            @Override
            public int compare(Thing o1, Thing o2) {
                return o1.area - o2.area;
            }
        });
        PriorityQueue<Thing> profitMax = new PriorityQueue<>(new Comparator<Thing>(){
            @Override
            public int compare(Thing o1, Thing o2) {
                return o2.profit-o1.profit;
            }
        });
        for(int i=0; i<num; i++) {
            costMin.add(arr[i]);
        }
        int max = Integer.MIN_VALUE;
        int current = 0;
        while(init > 0) {
            while(!costMin.isEmpty() && costMin.peek().area <= init) {
                Thing item = costMin.poll();
                if(item.area > 0 && item.profit < 0) continue;
                profitMax.add(item);
            }
            if(profitMax.isEmpty()) {
                break;
            }
            Thing temp = profitMax.poll();
            init -= temp.area;
            current += temp.profit;
            max = Math.max(current, max);
        }
        System.out.println(max);
    }
}
class Thing{
    public int area;
    public int profit;
    public Thing(int a, int b){
        area = a;
        profit = b;
    }
}
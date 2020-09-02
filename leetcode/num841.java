package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length = rooms.size();
        int[] visit = new int[length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            if(visit[pos] == 1) continue;
            visit[pos] = 1;
            count += 1;
            for (int item : rooms.get(pos)) {
                queue.add(item);
            }
        }
        return count == length;
    }
}
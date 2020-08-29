package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class num332 {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        int size = tickets.size() + 1;
        for (List<String> list : tickets) {
            String item = list.get(0);
            if (map.containsKey(item)) {
                map.get(item).offer(list.get(1));
                continue;
            }
            PriorityQueue<String> queue = new PriorityQueue<>();
            queue.offer(list.get(1));
            map.put(item, queue);
        }
        List<String> result = new LinkedList<>();
        dfs ("JFK", result, map);
        Collections.reverse(result);
        return result;
    }

    private static void dfs(String current, List<String> result, Map<String, PriorityQueue<String>> map) {
        while(map.containsKey(current) && map.get(current).size() > 0){
            String temp = map.get(current).poll();
            dfs(temp, result, map);
        }
        result.add(current);
    }

    public static void main(String[] args) {
        String[][] items = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> tickets = new ArrayList<>();
        for (String[] item : items) {
            List<String> list = new ArrayList<>();
            for (String str : item) {
                list.add(str);
            }
            tickets.add(list);
        }
        List<String> result = findItinerary(tickets);
        for (String item : result) {
            System.out.println(item);
        }
    }
}
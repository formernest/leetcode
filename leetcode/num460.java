package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class Item{
    int key;
    int count;
    public Item(int key, int count){
        this.key = key;
        this.count = count;
    }
}
class LFUCache {
    private int capacity;
    private PriorityQueue<Integer> list;
    private Map<Integer, Integer> count;
    private Map<Integer, Integer> map;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.count = new HashMap<>();
        this.list = new PriorityQueue<>((o1, o2)->(count.get(o1)-count.get(o2)));
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            count.put(key, count.get(key)+1);
            list.remove((Integer)key);
            list.offer(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(list.size()+1>capacity) return;
        if(list.size() == capacity && !map.containsKey(key)){
            Integer item = list.poll();
            count.remove(item);
            map.remove(item);
        }
        if(map.containsKey(key)){
            count.put(key, count.get(key)+1);
        }else{
            count.put(key, 1);
        }
        map.put(key, value);
        list.offer(key);
    }
}

public class num460 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }
}
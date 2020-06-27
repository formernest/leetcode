package daily_problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Integer> map = new HashMap<>();
    LinkedList<Integer> list = new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.remove((Integer)key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        int item = key;
        if(!map.containsKey(key) && list.size() == capacity){
            item = list.removeFirst();
        }
        map.remove(item);
        list.remove((Integer)item);
        map.put(key, value);
        list.addLast(key);
    }
}
package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    int capacity;
    LinkedList ageList;
    HashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        ageList = new LinkedList<Integer>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        Integer result = cache.get(key);
        if (result == null)
            return -1;
        ageList.remove(new Integer(key));
        ageList.addFirst(key);
        return result;
    }

    public void put(int key, int value) {
        cache.put(key, value);
        if (cache.size() > capacity) {
            cache.remove(ageList.removeLast());
        }
        ageList.remove(new Integer(key));
        ageList.addFirst(key);
    }
}

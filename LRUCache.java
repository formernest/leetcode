import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

class LRUCache {
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack stack = new Stack<Integer>();
    int capacity = 0;
    public LRUCache(int capacity) {
        capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            stack.remove(key);
            stack.add(key);
            return map.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(stack.size() < capacity){
            map.put(key, value);
            stack.add(key);
            capacity ++;
        }else{
            int peek = (int)stack.pop();
            map.remove(peek);
            stack.add(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));      // returns -1 (not found)
        System.out.println(cache.get(3));  // returns 3
        System.out.println(cache.get(4)); 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
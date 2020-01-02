import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    Bucket head;
    Bucket tail;
    Map<String, Integer> keyCount;
    Map<Integer, Bucket> countBucket;
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.next = tail;
        tail.pre = head;
        keyCount = new HashMap<String, Integer>();
        countBucket = new HashMap<Integer, Bucket>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(keyCount.containsKey(key)){
            moveKey(key, 1);
        }else{
            keyCount.put(key, 1);
            if(head.next.count != 1){
                addBucketAfter(new Bucket(1), head);
            }
            head.next.keySet.add(key);
            countBucket.put(1, head.next);
        }
    }

    public void moveKey(String key, int step){
        int count = keyCount.get(key);
        keyCount.put(key, count+step);
        Bucket p = countBucket.get(count);
        Bucket moveToBucket;
        if(countBucket.containsKey(count+step)){
            moveToBucket = countBucket.get(count+step);
        }else{
            moveToBucket = new Bucket(count+step);
            countBucket.put(count+step, moveToBucket);
            addBucketAfter(moveToBucket, step == 1? p:p.pre);
        }
        moveToBucket.keySet.add(key);
        removeKeyFromBucket(p, key);
    }

    public void removeKeyFromBucket(Bucket cur, String key){
        cur.keySet.remove(key);
        if(cur.keySet.size() == 0){
            countBucket.remove(cur.count);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
    }

    public void addBucketAfter(Bucket b, Bucket pre){
        Bucket temp = pre.next;
        pre.next = b;
        b.pre = pre;
        b.next = temp;
        temp.pre = b;
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keyCount.containsKey(key)){
            int count = keyCount.get(key);
            if(count == 1){
                keyCount.remove(key);
                removeKeyFromBucket(countBucket.get(count), key);
            }else{
                moveKey(key, -1);
            }
        }
    }
  
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head? "":tail.pre.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail? "":head.next.keySet.iterator().next();
    }
}

class Bucket{
    int count;
    Set<String> keySet;
    Bucket pre;
    Bucket next;

    public Bucket(int count){
        this.count = count;
        keySet = new LinkedHashSet<String>();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
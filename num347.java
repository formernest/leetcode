import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class num347 {
    public ArrayList<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        if(nums.length == 0) return array;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n2) - map.get(n1));
        for(int num: map.keySet()){
            heap.add(num);
        }
        while(k-- > 0){
            array.add(heap.poll());
        }
        return array;
    }
}
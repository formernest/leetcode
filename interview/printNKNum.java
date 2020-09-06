package interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * [程序员面试]：打印数组中超过一半的数
 * 
 */
public class printNKNum {
    /**
     * 打印数组中超过一半的数
     * 思路： 每次删除两个不相同的数，最后得到的即为超过一半的数
     * @param arr
     */
    public void printHalf(int[] arr) {
        int cand = 0;
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (times == 0) {
                cand = arr[i];
                times = 1;
            } else if (arr[i] == cand) {
                times++;
            } else {
                times--;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand) {
                count += 1;
            }
        }
        if (count >= arr.length / 2) {
            System.out.println(cand);
        } else {
            System.out.println("没有超过一半的数");
        }
    }

    /**
     * 打印数组中出现次数大于N/K的数
     * 每次删除k个不相同的数，最后得出的即为结果
     * @param arr
     * @param k
     */
    public void printNK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                if (map.size() == k - 1) {
                    allMapMinusOne(map);
                } else {
                    map.put(arr[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, map);
        for (Entry<Integer, Integer> entry : reals.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            boolean has = false;
            if (value > arr.length / k) {
                has = true;
                System.out.println(key);
            }
            System.err.println(has? "" : "no number");
        }

    }

    private HashMap<Integer, Integer> getReals(int[] arr, Map<Integer, Integer> map) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])) {
                int value = reals.getOrDefault(arr[i], 0);
                reals.put(arr[i], value+1);
            }
        }
        return null;
    }

    private void allMapMinusOne(Map<Integer, Integer> map) {
        List<Integer> list = new LinkedList<>();
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int current = entry.getValue();
            if (current == 1) {
                list.add(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue() - 1);
            }
        }
        for (int item : list) {
            map.remove(item);
        }
    }
}

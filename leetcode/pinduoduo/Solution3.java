package leetcode.pinduoduo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int T = scanner.nextInt();
        if(T == 0) {
            System.out.println(0);
            return;
        }
        int arr1[][] = new int[n1][2];
        int arr2[][] = new int[n2][2];
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i<n1; i++) {
            arr1[i][0] = scanner.nextInt();
            arr1[i][1] = scanner.nextInt();
            if (map.containsKey(arr1[i][1])) {
                map.put(T-arr1[i][1], Math.min(arr1[i][0], map.get(arr1[i][1])));
            }else{
                map.put(T-arr1[i][1], arr1[i][0]);
            }
        }
        min = map.containsKey(0)? map.get(0):min;
        for(int i=0; i<n2; i++) {
            arr2[i][0] = scanner.nextInt();
            arr2[i][1] = scanner.nextInt();
            if (arr2[i][1] >= T) {
                min = arr2[i][0] < min? arr2[i][0]:min;
            }
            for(int key:map.keySet()){
                if(arr2[i][1] >= key){
                    min = map.get(key)+arr2[i][0] < min? map.get(key)+arr2[i][0]:min;
                }
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
}
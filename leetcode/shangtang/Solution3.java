package leetcode.shangtang;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public int eraseOverlapIntervals (int[][] intervals) {
       if(intervals.length == 0) return 0;
       Arrays.sort(intervals, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2) {
               // TODO Auto-generated method stub
               return o1[1] - o2[1];
           }
       });
       int end = intervals[0][1];
       int count = 1;
       for (int i=1; i<intervals.length; i++) {
           if(intervals[i][0] >= end) {
               end = intervals[i][1];
               count ++;
           }
       }
       return intervals.length - count;
    }
    public static void main(String[] args) {
        int[][] matrix = { {1,2}, {2,3}, {3,4}, {1,3} };
        
    }
}
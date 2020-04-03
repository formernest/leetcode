package leetcode;

import java.util.Arrays;

class num435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        int end = Integer.MIN_VALUE;
        int count = 0;
        for(int[] i:intervals){
            if(i[0] >= end){
                count ++;
                end = i[1];
            }
        }
        return intervals.length - count;
    }
    public static void main(String[] args) {
        // int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        // int[][] intervals = {{1,2},{1,2},{1,2}};
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        int count = eraseOverlapIntervals(intervals);
        System.out.println(count);
    }
}
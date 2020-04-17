package daily_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day4_16 {
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if(length == 0) return new int[0][0];
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else if(end < intervals[i][0]){
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        int size = list.size();
        int[][] result = new int[size][2];
        return list.toArray(result);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        for(int[] items:result){
            for(int item:items){
                System.out.print(item + "  ");
            }
            System.out.println();
        }
    }
}
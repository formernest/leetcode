import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ali {
    // public int numSubarrayProductLessThanK(int[] nums, int k){
    //     int left = 0;
    //     int right = 0;
    //     int product = 1;
    //     int count = 0;
    //     while(left<nums.length){
    //         while(right<nums.length && product * nums[right] < k){
    //             product *= nums[right];
    //             right ++;
    //         }
    //         if(right <= left){
    //             right ++;
    //             left ++;
    //             product = 1;
    //         }else{
    //             count += (right - left);
    //             product /= nums[left];
    //             left ++;
    //         }

    //     }
    //     return count;
    // }
    
    public int[] findRightInterval(int[][] intervals) {
        int[][] origin = Arrays.copyOf(intervals);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });


    }
    public class Node{
        private int start;
         private int end;
        private int index;
        public Node(int start,int end,int index){
             this.start = start;
            this.end = end;
            this.index = index;
         }
     }
     public int binaryfind(Node[] record,int target){
        int left = 0;
        int right = record.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(record[mid].start>=target)
                right = mid-1;
             else
                left = mid+1;
         }
        if(left>=record.length)
            return -1;
        else
            return record[left].index;
     }
     public int[] findRInterval(int[][] intervals){
        Node[] record = new Node[intervals.length];
        for(int i=0;i<intervals.length;i++){
            record[i] = new Node(intervals[i][0],intervals[i][1],1);
         }
        Arrays.sort(record,(Node a,Node b)->{
            return a.start-b.start;
         });
         int[] res = new int[intervals.length];
        for(int j=0;j<res.length;j++){
            int target = record[j].end;
             int index = record[j].index;
            res[index] = binaryfind(record,target);
         }
        return res;
     }
    
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        ali s = new ali();
        System.out.println(s.numSubarrayProductLessThanK(nums, k));
    }
}

class ArrayIndexComparator implements Comparator<Integer>
{
    private final String[] array;

    public ArrayIndexComparator(String[] array)
    {
        this.array = array;
    }

    public Integer[] createIndexArray()
    {
        Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
        {
            indexes[i] = i; // Autoboxing
        }
        return indexes;
    }

    @Override
    public int compare(Integer index1, Integer index2)
    {
         // Autounbox from Integer to int to use as array indexes
        return array[index1].compareTo(array[index2]);
    }
}

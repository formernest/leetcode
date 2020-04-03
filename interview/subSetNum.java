package interview;

import java.util.LinkedList;

public class subSetNum {
    public int getNum(int[] arr){
        int res = 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i=0;
        int j=0;
        while(i<arr.length){
            while(j<arr.length){
                while(!qmin.isEmpty() && arr[qmin.peekLast()] > arr[j]){
                    qmin.pollLast();
                }
                qmin.add(j);
                while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[j]){
                    qmax.pollLast();
                }
                qmax.add(j);
            }
            res += j-i;
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        subSetNum solution = new subSetNum();
        // int[] arr = []
    }
}
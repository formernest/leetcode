package leetcode.pinduoduo;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int step = scanner.nextInt();
        int count = scanner.nextInt();
        int[] arr = new int[count];
        int curStep = 0;
        int back = 0;
        for (int i=0;i<count; i++){
            arr[i] = scanner.nextInt();
            if(curStep+arr[i]>step){
                curStep = 2*step-curStep-arr[i];
                back += 1;
            } else{
                curStep = curStep+arr[i];
            }
            if(curStep == step){
                System.out.println("paradox");
                return;
            }          
        }
        System.out.println(step-curStep + "\t" + back);
    }
}
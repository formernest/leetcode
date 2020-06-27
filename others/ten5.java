package others;

import java.util.Scanner;

public class ten5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            long num = scanner.nextLong();
            int depth = scanner.nextInt();
            long current = getParent(num, depth);
            System.out.println(current);
        }
    }
    public static long getParent(long n, int depth){
        int max_depth = (int) Math.round(Math.log10(n) / Math.log10(2))+1;
        if(depth == max_depth) return -1;
        while(max_depth-- > depth){
            n = n/2;
        }
        return n;
    }
}
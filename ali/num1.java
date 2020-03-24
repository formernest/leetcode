package ali;

import java.util.Scanner;

public class num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if(n==1) System.out.println(1);
        long p = n;
        long d=1;
        long count = p;
        for(long i=1; i<n; i++){
            p *= (n-i);
            d *= i;
            count += p;
        }
        System.out.println(count);
    }
    // public int cal(int n){
        
    // }

}
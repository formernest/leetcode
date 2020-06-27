package others;

import java.util.Scanner;

public class ten2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            int m = scanner.nextInt();
            scanner.nextLine();
            int[][] A = new int[m][2];
            for(int j=0; j<m; j++){
                A[j][0] = scanner.nextInt();
                A[j][1] = scanner.nextInt();
            }
            int[][] B = new int[m][2];
            for(int j=0; j<m; j++){
                B[j][0] = scanner.nextInt();
                B[j][1] = scanner.nextInt();
            }
            float min = Float.POSITIVE_INFINITY;
            for(int j=0; j<m; j++){
                for(int k=0; k<m; k++){
                    min = Math.min(min, distance(A[j][0], A[j][1], B[k][0], B[k][1]));
                }
            }
            System.out.println(min);
        }
    }
    public double distance(int a, int b, int c, int d){
        double result =  Math.sqrt(Math.pow(a-c, 2)+Math.pow(c-d, 2));
        return result;
    }
}
package others;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int MOD = 998244353;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] sum = new int[K][N];
        for(int i=0; i<N; i++){
            sum[0][i] = scanner.nextInt();
        }
        for(int i= 1; i<K; i++){
            for(int j = 0; j<N; j++){
                if(j == 0) sum[i][j] += (sum[i-1][j])%MOD;
                else sum[i][j] += (sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1])%MOD;
            }
        }
        System.out.println(sum[K-1][N-1]);
    }
}
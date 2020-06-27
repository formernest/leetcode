package daily_problem;
/**
 * pow(x,n)
 * 使用快速幂的方式
 */
public class day5_11{
    public double myPow(double x, int n) {
        long N = n;
        return n>=0? quickMul(x, N):1.00/quickMul(x, N);
    }
    public double quickMul(double x, long n){
        if(n==0) return 1;
        double y = quickMul(x, n/2);
        return n%2==0? y*y:y*y*x;
    }
}
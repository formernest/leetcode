import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        func(w,b);
    }
    public static void func(int n,int m){
        long[] d=new long[1000000];
        long count=0;
        int high=(int) Math.sqrt(2*(n+m));
        while (high*(high+1)>2*(n+m)) high--;
        if(n>0) d[1]=1;
        if(m>0) d[0]=1;
        for (int i=2;i<=high;i++){
            for (int j=(i+1)*i/2;j>=0;j--){
                if (i*(i+1)/2-j>m) d[j]=0;
                if (j<=n && j-i>=0) d[j]=(d[j-i]+d[j])%1000000007;
            }
        }
        for(int i=0;i<=n;i++){
            count=(count+d[i])%1000000007;
        }
        System.out.print(high+" "+count);
        return;
    }
}
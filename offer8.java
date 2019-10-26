
public class offer8 {
    public int cutRope(int target) {
        int mex = 0;
        if(target < 5) return target;
        else{
            for(int i=2; i<=target/2; i++){
                int m1 = target/i;
                int m2 = target%i;
                int temp = m2 == 0? m1^i : Math.max(Math.pow(m1, i-1)*m2, Math.pow(m1, i-2)*);
            }
        }
    }
}
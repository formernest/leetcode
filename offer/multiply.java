import java.util.ArrayList;
import java.lang.Math;
public class multiply {
    public int[] multiply(int[] A) {
        if(A.length == 0) return null;
        int sum = 1;
        for(int i=0; i<A.length; i++){
            sum *= A[i];
        }
        if(sum == 0){
            sum = 1; //计算除0之外的所有元素的乘积
            int flag = 0;
            int index = 0;
            for(int i=0; i<A.length; i++){
                if(A[i] != 0 && flag <2){
                    sum *= A[i];
                }else if(A[i] == 0 && flag < 2){
                    index = i;
                    flag ++;
                }else{
                    break;
                }
            }
            for(int i=0; i<A.length; i++){
                A[i] = 0;
            }
            if(flag<2){
                A[index] = sum;
            }
            return A;
        }else{
            int[] B = new int[A.length];
            B[0]=1; B[A.length-1]=1;
            for(int i=1; i<A.length-1; i++){
                B[i] = (int)(sum * Math.pow(A[i], -1));
            }
            return B;
        }
    }
}
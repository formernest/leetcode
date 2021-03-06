package daily_problem;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n==1;
    }
    public int getNext(int n){
        int sum = 0;
        while(n!=0){
            int temp = n%10;
            n = n/10;
            sum += temp * temp;
        }
        return sum;
    }
}
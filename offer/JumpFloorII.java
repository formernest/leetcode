public class JumpFloorII {
    public int JumpFloorII(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        int sum = 1;
        for(int i=1; i<target; i++){
            sum += JumpFloorII(i);
        }
        return sum;
    }
}
public class cutRope {
    public int cutRope(int target) {
        return cut(target, false);
    }
    public int cut(int target, boolean flag){
        if(target == 1) return 1;
        if(flag == false && target == 2) return 1;
        int max = 1;
        for(int i=1; i<=target/2+1; i++){
            int temp = i * cut(target - i, true);
            max = temp > max? temp : max;
        }
        return max;
    }
    public static void main(String[] args) {
        cutRope s = new cutRope();
        int target = 8;
        System.out.println(s.cutRope(target));
    }
}
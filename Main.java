public class Main{

    public  int func(int num, int[] d,int[] p, int start, int curhire, int curvoilent){
        if(start>=num)
            return curhire;
        if(curvoilent<d[start]){//武力值不够
            return func(num, d, p, start+1, curhire+p[start], curvoilent+d[start]);
        }else{
            return Math.min(
                    func(num, d, p, start+1, curhire+p[start], curvoilent+d[start]),//买
                    func(num, d, p, start+1, curhire, curvoilent)//不买
            );
        }
    }

    private int help(int num, int[] d, int[] p){
        return func(num, d, p, 1, p[0], d[0]);
    }

    public static void main(String args[]){
        int[] d = new int[]{1,2,4,8};
        int[] p = new int[]{1,2,1,2};
        Main m = new Main();
        System.out.print(m.func(d.length,d,p,1,p[0],d[0]));
    }
}
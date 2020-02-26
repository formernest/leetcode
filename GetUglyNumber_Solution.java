import java.util.LinkedList;

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        LinkedList<Integer> res = new LinkedList<Integer>();
        res.add(1);
        int i2=0, i3=0, i5=0;
        while(res.size() < index){
            int m2 = res.get(i2) * 2;
            int m3 = res.get(i3) * 3;
            int m5 = res.get(i5) * 5;
            int min = get_Min(m2, get_Min(m3, m5));
            res.add(min);
            if(m2 == min) i2++;
            if(m3 == min) i3++;
            if(m5 == min) i5++;
        }
        return res.get(res.size()-1);
    }
    public int get_Min(int a, int b){
        return a>b? b:a;
    }
}
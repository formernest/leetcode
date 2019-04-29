import java.util.ArrayList;
import java.util.List;

class num89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int count =(int)Math.pow(2, n);
        for(int i=0; i<count; i++){
            result.add(i ^ (i>>1));
        }
        return result;
    }
    public static void main(String[] args) {
        num89 s = new num89();
        List<Integer> result = s.grayCode(2);
        for(int i=0; i< result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
import java.util.Arrays;

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        Arrays.sort(array);
        int num = array[array.length/2];
        int count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == num) count ++;
        }
        if(count <= array.length/2){
            return 0;
        }
        return num;
    }
}
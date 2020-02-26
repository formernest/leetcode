import java.util.ArrayList;
import java.util.Arrays;
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length < k) return result;
        Arrays.sort(input);
        for(int i=0; i<k; i++){
            result.add(input[i]);
        }
        return result;
    }
}
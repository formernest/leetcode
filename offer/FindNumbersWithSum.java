import java.util.ArrayList;
import java.util.Arrays;
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(array.length == 0) return ans;
        int min = Integer.MAX_VALUE;
        int i=0, j=array.length-1;
        while(i<j){
            if(array[i] + array[j] == sum){
                if(array[i]*array[j] < min){
                    ans = new ArrayList<>(Arrays.asList(array[i], array[j]));
                    min = array[i]*array[j];
                }
                i++;
                j--;
            }else if(array[i] + array[j] < sum){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int sum = 21;
        FindNumbersWithSum solution = new FindNumbersWithSum();
        ArrayList<Integer> ans = solution.FindNumbersWithSum(array, sum);
        for(Integer item:ans){
            System.out.println(item);
        }
    }
}
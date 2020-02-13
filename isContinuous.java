import java.util.Arrays;

public class isContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);
        int k=0;
        while(numbers[k] ==0){
            k ++;
        }
        int i = k;
        while(i < numbers.length-1 && k>=0){
            if(numbers[i] == numbers[i+1]) return false;
            if(numbers[i] + 1 + k >= numbers[i+1]){
                k -= numbers[i+1] - numbers[i] - 1;
            }else{
                return false;
            }
            i++;
        }
        if(i == numbers.length-1) return true;
        else return false;
    }
    public static void main(String[] args) {
        int[] numbers = {1,3,2,5,4};
        isContinuous solution = new isContinuous();
        System.out.println(solution.isContinuous(numbers));
    }
}
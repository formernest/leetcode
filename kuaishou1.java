import java.util.ArrayList;
import java.util.List;

public class kuaishou1{
    public List<Integer> getIndex(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        if(nums.length <= 1) return result;
        int i=1;
        while(i<nums.length){
            int count = 0;
            while(i<nums.length && nums[i]==nums[i-1]){
                if(nums[i] < first && nums[i] >= second){
                    result.add(i);
                }
                count++;
                i++;
            }
            if(count == 0){
                if(nums[i] > first){
                    second = first;
                    first = nums[i];
                }else if(nums[i] > second){
                    second = nums[i];
                }
            }
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 22, 22, 33, 22, 12, 45, 44, 5};
        kuaishou1 solution = new kuaishou1();
        List<Integer> res = solution.getIndex(nums);
        for(Integer item:res){
            System.out.println(Integer.valueOf(item));
        }

    }
}
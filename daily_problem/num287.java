package daily_problem;

import java.util.Arrays;
import java.util.List;

public class num287 {
    public int findDuplicate(int[] nums) {
        int item = 0;
        for(int num:nums){
            item ^= num;
        }
        return item;
    }

    public static void main(String[] args) {
        String s = "a, b, c, d";
        List<String> list = Arrays.asList(s.split(","));
        System.out.println(StringUtils.join(list.toArray(), ","));
    }
}
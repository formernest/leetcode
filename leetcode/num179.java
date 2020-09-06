package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class num179 {
    public String largestNumber(int[] nums) {
        String result = "";
        String[] nums_I = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_I[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums_I, new MyComparator());
        if (nums_I[0].equals("0")) {
            return "0";
        }
        for (String item : nums_I) {
            result += item;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 30, 34, 5, 9 };
        num179 solution = new num179();
        System.out.println(solution.largestNumber(nums));
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String order1 = o1 + o2;
        String order2 = o2 + o1;
        return order2.compareTo(order1);
    }
}

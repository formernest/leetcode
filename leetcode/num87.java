package leetcode;

import java.util.Arrays;

class num87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!String.valueOf(arr1).equals(String.valueOf(arr2)))
            return false;
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;
            s21 = s2.substring(s1.length() - i);
            s22 = s2.substring(0, s1.length() - i);
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "caebd";
        num87 solution = new num87();
        System.out.println(solution.isScramble(s1, s2));
    }
}
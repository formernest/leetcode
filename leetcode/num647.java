package leetcode;

public class num647 {
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                if (isValid(s, i, j)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private static boolean isValid(String s, int i, int j) {
        while (i<=j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
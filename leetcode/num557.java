package leetcode;

public class num557 {
    public static String reverseWords(String s) {
        String result = "";
        String[] strs = s.split(" ");
        for (String str : strs) {
            result += ' ' + reverse(str);
        }
        return result.substring(1);
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        int index = str.length() - 1;
        while (index >= 0) {
            sb.append(str.charAt(index--));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
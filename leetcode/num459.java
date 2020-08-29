package leetcode;

public class num459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s, 1) != s.length();
    }
}
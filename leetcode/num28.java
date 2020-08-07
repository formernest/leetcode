package leetcode;
/**
 *  Implement strStr().
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    Example 1:
    Input: haystack = "hello", needle = "ll"
    Output: 2

    Example 2:
    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
 */
class num28 {
    // public int strStr(String haystack, String needle) {
    //     if(needle == "") return 0;
    //     return haystack.indexOf(needle);
    // }
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        int i = 0, j = 0;
        while (i < h) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                i ++;
                j = 0;
            } else {
                i ++;
                j ++;
            }
            if (j == n) return i-n;
        }
        return -1;
    }
    public static void main(String[] args) {
        num28 s = new num28();
        System.out.println(s.strStr("hello", "ll"));
    }
}
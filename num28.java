class num28 {
    public int strStr(String haystack, String needle) {
        if(needle == "") return 0;
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        num28 s = new num28();
        System.out.println(s.strStr("aaaaa", "bba"));
    }
}
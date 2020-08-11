package leetcode;

class num9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int current;
        int result = 0;
        int origin = x;
        while (x != 0) {
            current = x % 10;
            result = result * 10 + current;
            x = x / 10;
        }
        if (result == origin)
            return true;
        return false;
    }

    public static void main(String[] args) {
        num9 s = new num9();
        System.out.println(s.isPalindrome(10));
    }
}
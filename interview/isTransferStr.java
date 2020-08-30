package interview;

/**
 * 程序员面试：判断两个字符串是否为变形词
 */
public class isTransferStr {
    public static boolean isTransfer(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] map = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)]++;
        }
        for (int j = 0; j < s2.length(); j++) {
            if (--map[s2.charAt(j)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "3211";
        System.out.println(isTransfer(s1, s2));
    }
}

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        if(length == 0) return "";
        n = n % length;       
        str = str.substring(n, length) + str.substring(0, n);
        return str;       
    }
    public static void main(String[] args) {
        String str = "abcXYZdef";
        LeftRotateString solution = new LeftRotateString();
        int n=3;
        System.out.println(solution.LeftRotateString(str, n));
    }
}
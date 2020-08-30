package interview;

public class transferNum {
    public static int numOfTrans(String s) {
        char[] arr = s.toCharArray();
        return help(arr, 0);
    }

    public static int help(char[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        if (arr[index] == '0') {
            return 0;
        }
        int result = help(arr, index + 1);
        if (index + 1 < arr.length && (arr[index] - '0') * 10 + arr[index + 1] - '0' < 27) {
            result += help(arr, index + 2);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "1111";
        System.out.println(numOfTrans(s));
    }
}
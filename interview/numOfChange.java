package interview;

/**
 * 程序员面试：换钱的方法数
 */
public class numOfChange {
    public static int getNum(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return help(arr, 0, aim);
    }

    public static int help(int[] arr, int index, int aim) {
        int result = 0;
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                result += help(arr, index + 1, aim - arr[index] * i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 25, 1 };
        int aim = 15;
        System.out.println(getNum(arr, aim));
    }
}
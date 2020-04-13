package daily_problem;
/**
 * 翻转字符串里的单词
 */
public class day7 {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        String result = "";
        for(int i=arr.length-1; i>=0; i--){
            if(!arr[i].trim().equals("")){
                result += arr[i];
                result += " ";
            }
            // System.out.println(arr[i]);
        }
        return result.trim();
    }
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}

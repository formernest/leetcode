package daily_problem;
/**
 * 一次编辑
 * 确保first>second
 * 1、找到两个字符串不相等的位置
 * 2、剩下的字符分两种情况，一种为删除一种为替换；如果删除，则除了不等位置的字符其他必须相同；如果替换，则
 */
public class oneEdit {
    public static boolean isOne(String first, String second){
        int len1 = first.length();
        int len2 = second.length();
        if(Math.abs(len1 - len2) > 1) return false;
        if(len1 < len2) return isOne(second, first);
        int i=0, j=0;
        while(i<len1 && j<len2){
            if(first.charAt(i) != second.charAt(j)){
                return first.substring(i+1).equals(second.substring(j+1)) || first.substring(i+1).equals(second.substring(j));
            }
            i++;
            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        String first = "pales";
        String second = "pal";
        System.out.println(isOne(first, second));
    }
}
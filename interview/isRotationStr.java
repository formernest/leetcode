package interview;
/**
 * 程序员面试：判断两个字符串是否为旋转词
 */
public class isRotationStr{
    public static boolean isRotation(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }
        String temp = s2 + s2;
        return temp.indexOf(s1) != -1;
    }
    public static void main(String[] args) {
        String s1 = "1ab2";
        String s2 = "ab12";
        System.out.println(isRotation(s1, s2));
    }
}
package interview;
/**
 * 大数相加，使用字符串
 */
public class BigNumAdd{
    public static void main(String[] args) {
        String s1 = "12345";
        String s2 = "5432";
        String result = add(s1, s2);
        System.out.println(result);
    }
    public static String add(String s1, String s2){
        if(s1 == null || "".equals(s1)){
            return s2;
        }
        if(s2 == null || "".equals(s2)){
            return s1;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int index1 = arr1.length-1;
        int index2 = arr2.length-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(index1>=0 && index2>=0){
            int current = arr1[index1--]-'0'+arr2[index2--]-'0'+carry;
            sb.append(current%10);
            carry = current/10;
            
        }
        while(index1>=0){
            int current = arr1[index1--]-'0'+carry;
            sb.append(current%10);
            carry = current/10;
        }
        while(index2>=0){
            int current = arr1[index2--]-'0'+carry;
            sb.append(current%10);
            carry = current/10;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
public class offer2 {
    //替换空格
    public String replaceSpace(StringBuffer str) {
        int size = str.length();
        String result = "";
        for(int i=0; i<size; i++){
            if(str.charAt(i) == ' '){
                result += "%20";
            }else{
                result += String.valueOf(str.charAt(i));
            }
        }
        return result;       
    }
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        offer2 solution = new offer2();
        System.out.println(solution.replaceSpace(str));
    }
}
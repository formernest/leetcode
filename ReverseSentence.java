public class ReverseSentence {
    public String ReverseSentence(String str) {
        String[] strs = str.split(" ");
        int length = strs.length;
        if(length == 0 || length == 1) return str;
        for(int i=0; i<length/2; i++){
            String s = strs[i];
            strs[i] = strs[length-1-i];
            strs[length-1-i] = s;
        }
        str = strs[0];
        for(int i=1; i<length; i++){
            str += ' ' + strs[i];
        }
        return str;
    }
    public static void main(String[] args) {
        String str = "student. a am I";
        ReverseSentence solution = new ReverseSentence();
        System.out.println(solution.ReverseSentence(str));
    }
}
public class StrToInt {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0) return 0;
        int fuhao = 0;
        if(str.startsWith("-")){
            fuhao = 1;
        }
        long sum = 0;
        for(int i=fuhao; i<str.length(); i++){
            if(str.charAt(i) == '+'){
                continue;
            }
            if(str.charAt(i) < 48 || str.charAt(i) > 57){
                return 0;
            }
            sum = sum * 10 + str.charAt(i) - 48;
            if(fuhao == 0 && sum>Integer.MAX_VALUE) return 0;
            else{
                if(sum>Integer.MAX_VALUE+1) return 0;
            }
        }     
        return fuhao == 0? (int)sum:(int)sum*(-1);
    }
    public static void main(String[] args) {
        StrToInt solution = new StrToInt();
        String str = "-123";
        int result = solution.StrToInt(str);
        System.out.println(result);
    }
}
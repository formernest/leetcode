import java.util.Scanner;

class tencent{
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int num = Integer.parseInt(scanner.next());
        // scanner.nextLine();
        // String s = scanner.next();
        String s = "1100";
        while(s.indexOf("01")!=-1||s.indexOf("10")!=-1){
            s = s.replace("01", "");
            s = s.replace("10", "");
        }
        System.out.println(s.length());
    }
    public int minLength(String s){
        while(s.indexOf("01")!=-1||s.indexOf("10")!=-1){
            s = s.replace("01", "");
            s = s.replace("10", "");
        }
       return s.length();
    }
}
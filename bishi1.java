import java.util.Scanner;
public class bishi1{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String src = in.next();
        StringBuilder tmp = new StringBuilder(20);
        StringBuilder goal = new StringBuilder(src.length());
        char c;
        for (int i=src.length()-1;i>=0;i--){
            c = src.charAt(i);
            if((c>=32&&c<=47) || (c>=58&&c<=64) || (c>=91&&c<=96) || (c>=123&&c<=126)){
                goal.append(tmp);
                goal.append(c);
                tmp.delete(0,tmp.length());
            }else {
                tmp.insert(0,c);
            }
        }
        if (!tmp.equals("")){
            goal.append(tmp);
        }
        System.out.println(goal.toString());
    }
}

import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> sList=new ArrayList<>();
        String str=sc.nextLine();
        String[] strs = str.split(" ");
        for(int i=0;i<strs.length;i++){
            sList.add(strs[i]);
        }
        boolean result=wordBreak(s, sList);
        if(result){
            System.out.print("True");
        }else{
            System.out.print("False");
        }     
        sc.close();
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
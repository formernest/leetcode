import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int N = Integer.parseInt(line1.split(" ")[0]);
        int Q = Integer.parseInt(line1.split(" ")[1]);
        int[] a = new int[N];
        String line2 = sc.nextLine();
        String[] line2str = line2.split(" ");
        for(int i=0;i < N;i++){
            a[i] = Integer.parseInt(line2str[i]);
        }
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<N-1;i++){
            String line = sc.nextLine();
            String[] items = line.split(" ");
            map.put(items[0] + "_" + items[1], items[2]);
        }
        int[] startNums = new int[Q];
        for(int i=0;i<startNums.length;i++){
            startNums[i] = Integer.parseInt(sc.nextLine());
        }
    }
    public static void dp(){
        List<String> list = new ArrayList<String>();
    }
}
package others;

import java.util.Scanner;

public class wangyi3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_preson = scanner.nextInt();
        int num_party = scanner.nextInt();
        int start = scanner.nextInt();
        scanner.nextLine();
        int count = 1;
        int[] map = new int[num_preson];
        map[start] = 1;
        for(int i=0; i<num_party; i++){
            boolean flag = false;
            String[] s = scanner.nextLine().split(" ");
            for(String item : s){
                int num = Integer.valueOf(item);
                if(map[num] == 1){
                    flag = true;
                    break;
                }
            }
            if(flag){
                for(String item : s){
                    int num = Integer.valueOf(item);
                    if(map[num] == 0){
                        count += 1;
                    }
                    map[num] = 1;
                }
            }            
        }
        System.out.println(count);
    }
}
import java.util.Scanner;

public class meituan2{
    //5  2 1 3 2 5
    //3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        if(n <= 1) System.out.println(n);
        int[] dpleft = new int[n];
        int[] dpright = new int[n];
        dpleft[0] = 1;
        dpright[n-1] = 1;
        int max = 1;
        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]) dpleft[i] = dpleft[i-1]+1;
            else dpleft[i] = 1;
            // max = Math.max(max, dpleft[i]);
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]) dpright[i] = dpright[i+1]+1;
            else dpright[i] = 1;
            // max = Math.max(max, dpright[i]);
        }
        for(int i=1; i<n-1; i++){
            if(nums[i-1] < nums[i+1]){
                max = Math.max(max, dpleft[i-1] + dpright[i+1]);
            }
        }
        System.out.println(max);
    }
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int n = scanner.nextInt();
    //     int[] nums = new int[n];
    //     for(int i=0; i<n; i++){
    //         nums[i] = scanner.nextInt();
    //     }
    //     if(n <= 1) System.out.println(n);
    //     int[] nochange = new int[n];
    //     int[] change = new int[n];
    //     nochange[0] = 1;
    //     change[0] = 1;
    //     int ans = 0;
    //     for(int i=1;i<n;i++) {
    //         if(nums[i]>nums[i-1]) {
    //             nochange[i] = nochange[i-1]+1;
    //             change[i] = change[i] + 1; 
    //         } else if(i>1&&nums[i-2]<nums[i]){
    //             nochange[i] = 1;
    //             change[i] = Math.max(nochange[i-2]+1,2);
    //         } else {
    //             nochange[i] = 1;
    //             change[i] = 2;
    //         }
    //         ans = Math.max(ans, change[i]);
    //     }
    //     System.out.println(ans);
    // }
}
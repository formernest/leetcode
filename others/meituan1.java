import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class meituan1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if(n<3) return;
        PriorityQueue<Long> nums1 = new PriorityQueue<Long>(new Comparator<Long>(){
            @Override
            public int compare(Long l1, Long l2){
                return l2.compareTo(l1);
            }
        });
        PriorityQueue<Long> nums2 = new PriorityQueue<Long>(new Comparator<Long>(){
            @Override
            public int compare(Long l1, Long l2){
                return l2.compareTo(l1);
            }
        });
        for(int i=0; i<n; i++){
            nums1.offer(scanner.nextLong());  
        }
        // for(int i=0;i<len;i++){  
        //     System.out.print(pq.poll()+" ");  
        // } 
        for(int i=0; i<n; i++){
            nums2.offer(scanner.nextLong());
        }
        
        long sum1 = 0;
        long sum2 = 0;
        int k = 3;
        while(k>0){
            sum1 += nums1.poll();
            sum2 += nums2.poll();
            k--;
        }
        System.out.println(Math.max(sum1, sum2));
    }
}
package interview;
/**
 * 求1到1000000的质数
 * https://github.com/muhualing/coding-interview-chinese/tree/master/microsoft
 * 
 */
public class prime{
    public static void main(String[] args) {
        int NUM = 1000000;
        System.out.println(2);
        int j=3;
        for(int i=3; i<=NUM; i+=2){
            for(j=3; j<i; j+=2){
                if(i % j == 0 || j*j > i){
                    break;
                }
            }
            if(j*j > i){
                System.out.println(i);
            }
        }
    }
}
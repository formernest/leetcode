public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count += 1;
            n = (n-1) & n;
        }
        return count;
    }
    public static void main(String[] args) {
        NumberOf1 solution = new NumberOf1();
        System.out.println(solution.NumberOf1(3));
    }
}
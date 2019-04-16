
class num29 {
    public int divide(int dividend, int divisor) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int result;
        if(dividend == min && divisor == -1){
            return max;
        }
        result = dividend/divisor;
        if(result<min || result>max) result = max;
        return result;
    }
    public static void main(String[] args) {
        num29 s = new num29();
        System.out.println(s.divide(-2147483648,-1));
    }
}
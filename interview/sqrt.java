package interview;

public class sqrt {
    public static double mySqrt(double n) {
        double x = 1.0;
        while (Math.abs(x * x - n) > 0.00001) {
            x = (x + n / x) / 2;
        }
        return x;
    }

    public static void main(String[] args) {
        double result = mySqrt(9);
        System.out.println(result);
    }
}

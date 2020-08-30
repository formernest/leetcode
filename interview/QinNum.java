package interview;

/**
 * https://github.com/muhualing/coding-interview-chinese/tree/master/microsoft
 * 相亲数，两个正整数中，彼此的全部正约数之和与另一方相等 220的所有因子(除了自己以外的因子)：1+2+4+5+10+11+20+22+44+55+110
 * = 284，284的所有因子：1+2+4+71+142 = 220
 */
public class QinNum {
    public boolean isQin(int a, int b) {
        if (a == 0 && b == 0)
            return true;
        int suma = 1;
        for (int i = 2; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0) {
                suma += i;
                suma += a / i;
            }
        }
        if (suma != b)
            return false;
        int sumb = 1;
        for (int i = 2; i <= (int) Math.sqrt(b); i++) {
            if (b % i == 0) {
                sumb += i;
                sumb += b / i;
            }
        }
        if (sumb != a)
            return false;
        return true;
    }

    public static void main(String[] args) {
        QinNum solution = new QinNum();
        boolean result = solution.isQin(220, 284);
        System.out.println(result);
    }
}
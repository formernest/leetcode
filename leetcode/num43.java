package leetcode;

class num43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty())
            return "";
        int l1 = num1.length(), l2 = num2.length();
        int[] result = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int k = l1 + l2 - 1; k > 0; k--) {
            result[k - 1] += result[k] / 10;
            result[k] = result[k] % 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < result.length; k++) {
            if (sb.length() == 0 && result[k] == 0)
                continue;
            sb.append(result[k]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        num43 s = new num43();
        String num1 = "123";
        String num2 = "";
        System.out.println(s.multiply(num1, num2));
    }
}
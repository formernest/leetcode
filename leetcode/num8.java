package leetcode;

class num8 {
    public int myAtoi(String str) {
        int result;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        if (!(Character.isDigit(str.charAt(0)) || str.charAt(0) == '+' || str.charAt(0) == '-')) {
            return 0;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            if (str.length() == 1)
                return 0;
            if (!Character.isDigit(str.charAt(1)))
                return 0;
        }
        int end;
        for (end = 1; end < str.length(); end++) {
            if (!Character.isDigit(str.charAt(end))) {
                break;
            }
        }
        try {
            if (str.contains(".")) {
                result = (int) (Float.parseFloat(str.substring(0, end)));
            } else {
                result = Integer.parseInt(str.substring(0, end));
            }
        } catch (Exception NumberFormatException) {
            if (str.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        num8 s = new num8();
        System.out.println(s.myAtoi("-42"));
    }
}
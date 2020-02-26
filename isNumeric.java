public class isNumeric {
    public boolean isNumeric(char[] str) {
        String s = str.toString();
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
        //return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
    public static void main(String[] args) {
        isNumeric solution = new isNumeric();
        String s = "+100"; //"5e2","-123","3.1416"和"-1E-16"
        char[] str = s.toCharArray();
        System.out.println(solution.isNumeric(str));
    }
}
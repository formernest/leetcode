import java.util.List;

class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        int e_len = evalvars.length;
        for(int i=0; i<e_len; i++){
            expression = expression.replace(evalvars[i], String.valueOf(evalints[i]));
        }
    }
}
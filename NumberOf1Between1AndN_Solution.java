public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while(n>0){
            String str = String.valueOf(n);
            char[] array = str.toCharArray();
            for(char c:array){
                if(c == '1') count++;
            } 
            n--;
        }
        return count;
    }
}
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str.length() ==0) return -1;
        int[] count = new int[256];
        int min = Integer.MAX_VALUE;
        for(int i=0; i< str.length(); i++){
            char c = str.charAt(i);
            if(count[c] == 0) count[c] ++;
            else count[c] = -1;
        }
        for(int i=0; i<str.length(); i++){
            if(count[str.charAt(i)] == 1){
                min = i;
                break;
            }
        }
        if(min != Integer.MAX_VALUE) return min;
        return -1;
    }
}
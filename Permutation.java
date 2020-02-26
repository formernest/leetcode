import java.util.ArrayList;
import java.util.Collections;
public class Permutation {
    public ArrayList<String> Permutation(String str) {
       char[] s = str.toCharArray();
       ArrayList<String> result = new ArrayList<>();
       if(str != null && str.length() != 0){
           help(0, s, result);
           Collections.sort(result);
       }
       return result;
    }
    public void help(int start, char[] s, ArrayList<String> result){
        if(start == s.length-1){
            String value = String.valueOf(s);
            if(!result.contains(value)){
                result.add(value);
            }
        }else{
            for(int i=start; i< s.length; i++){
                swap(s, start, i);
                help(start+1, s, result);
                swap(s, start, i);
            }
        }
    }
    public void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
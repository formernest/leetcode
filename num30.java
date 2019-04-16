import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class num30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length==0) return result;
        List<String> list = new ArrayList<>();
        for(String str:words){
            list.add(str);
        }
        while(!list.isEmpty()){
            
        }
    }
    public boolean search(String s, String search, int begin, int end){
        int index = s.substring(begin, end).indexOf(search);
        if(index-begin==search.length()||end-index==search.length()) return true;
        return false;
    }
}
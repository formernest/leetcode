import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

class num49{
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = num49.groupAnagrams(strs);
        for(List strlist:list){
            for(Object s:strlist){
                System.out.print(s+" ");
            }
            System.out.println('\n');
        }
    }
    // 对每一个字符串进行排序的方法
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i=0; i<strs.length; i++){
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
    // 使用字符数组的方法
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            int[] count = new int[26];
            for(int i=0; i<str.length(); i++){
                count[str.charAt(i) - 'a'] += 1;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }else{
                map.get(key).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}
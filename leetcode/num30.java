package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class num30 {
    public ArrayList<Integer> findSubstring(String s, String[] words) {
        int lenarr = words.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (lenarr == 0)
            return result;
        int lenStr = words[0].length();
        for (int i = 0; i <= s.length() - lenStr * lenarr; i++) {
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(words));
            for (int j = 0; j < lenarr; j++) {
                int pos = temp.indexOf(s.substring(i + j * lenStr, i + (j + 1) * lenStr));
                if (pos == -1)
                    break;
                temp.remove(pos);
            }
            if (temp.size() == 0)
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        num30 n = new num30();
        String s = "barfoothefoobarman";
        String[] words = new String[] { "foo", "bar" };
        ArrayList<Integer> result = n.findSubstring(s, words);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
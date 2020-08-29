package leetcode.bigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    private static Integer pos;
    
    public static String getServer () {
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.put("A", 4);
        serverMap.put("B", 2);
        serverMap.put("C", 1);
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        List<String> serverList = new ArrayList<>();
        while(iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i=0; i<weight; i++) {
                serverList.add(server);
            }
        }
        String server = null;
        if (pos > keySet.size()) {
            pos = 0;
        }
        server = serverList.get(pos);
        pos ++;
        return server;
    }
}
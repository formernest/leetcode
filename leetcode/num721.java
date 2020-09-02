package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集
 */
public class num721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if ("".equals(name)) {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                // 构造并查集
                dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        // 根据并查集计算结果<index, list>
        Map<Integer, List<String>> ans = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToId.get(email));
            ans.computeIfAbsent(index, x -> new ArrayList()).add(email);
        }
        // 将名字插入到行头
        for (List<String> item : ans.values()) {
            Collections.sort(item);
            item.add(0, emailToName.get(item.get(0)));
        }
        return new ArrayList<>(ans.values());
    }
}

class DSU {
    int[] parent;

    public DSU() {
        parent = new int[10001];
        for (int i = 0; i < 10001; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
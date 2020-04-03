package leetcode;

import java.util.HashSet;
import java.util.Set;

class num547 {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int[] p = new int[len];
        for(int i=0; i<len; i++){
            p[i] = i;
        }
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(M[i][j] == 1) merge(p, i, j);
            }
        }
        Set<Integer> S = new HashSet<>();
        for(int i=0; i<len; i++){
            S.add(p[i]);
        }
        return S.size();
    }
    public void merge(int[] p, int x, int y){
        int xf = find(p, x);
        int yf = find(p, y);
        if(xf == yf) return;
        int min = Math.min(xf, yf);
        int max = Math.max(xf, yf);
        for(int i=0; i<p.length; i++){
            if(p[i] == max) p[i] = min;
        }
    }
    public int find(int[] p, int x){
        while(p[x]!=x){
            x = p[x];
        }
        return x;
    }
}
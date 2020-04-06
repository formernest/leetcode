package interview;
/**
 * 程序员面试：最短通路值
 */
import java.util.LinkedList;

public class minPathValue {
    public static int minPath(int[][] m){
        if(m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1 || m[m.length-1][m[0].length-1] != 1){
            return 0;
        }
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        LinkedList<Integer> r_queue = new LinkedList<>();
        LinkedList<Integer> c_queue = new LinkedList<>();
        r_queue.add(0);
        c_queue.add(0);
        while(!r_queue.isEmpty()){
            int r = r_queue.pollFirst();
            int c = c_queue.pollFirst();
            if(r==m.length-1 && c==m[0].length-1){
                return map[r][c];
            }
            dfs(map[r][c], r+1, c, m, map, r_queue, c_queue);
            dfs(map[r][c], r-1, c, m, map, r_queue, c_queue);
            dfs(map[r][c], r, c+1, m, map, r_queue, c_queue);
            dfs(map[r][c], r, c-1, m, map, r_queue, c_queue);
        }
        return 0;
    }
    public static void dfs(int pre, int r, int c, int[][] m, int[][] map, LinkedList<Integer> r_queue, LinkedList<Integer> c_queue){
        if(r < 0 || r>=m.length || c<0 || c>=m[0].length || pre == 0 || m[r][c] != 1 || map[r][c] != 0){
            return;
        } 
        map[r][c] = pre + 1;
        r_queue.add(r);
        c_queue.add(c);
    }
    public static void main(String[] args) {
        int[][] m = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };
        System.out.println(minPath(m));
    }
}
package daily_problem;
/**
 * 机器人运动的范围
 * 使用递推的方式
 */
public class day5 {
    public int movingCount(int m, int n, int k) {
        if(k < 0) return 0;
        int[][] map = new int[m][n];
        map[0][0] = 1;
        int count = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 && j==0) || getSum(i) + getSum(j) > k) continue;
                if(i-1 >= 0) map[i][j] |= map[i-1][j];
                if(j-1 >= 0) map[i][j] |= map[i][j-1];
                count += map[i][j];
            }
        }
        return count;
    }
    public int getSum(int num){
        int sum = 0;
        while(num != 0){
           sum += num % 10;
           num /= 10; 
        }
        return sum;
    }
}

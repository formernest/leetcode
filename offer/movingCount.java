public class movingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] flags = new boolean[rows * cols];
        return helper(threshold, rows, cols, 0, 0, flags);
    }
    public int helper(int threshold, int rows, int cols, int row, int col, boolean[] flags){
        if(row<0||row>=rows||col<0||col>=cols) return 0;
        int index = row * cols + col;
        if(flags[index] || !valid(row, col, threshold)) return 0;
        flags[index] = true;
        return 1 + helper(threshold, rows, cols, row+1, col, flags)+
                   helper(threshold, rows, cols, row-1, col, flags)+
                   helper(threshold, rows, cols, row, col-1, flags)+
                   helper(threshold, rows, cols, row, col+1, flags);
    }
    public boolean valid(int row, int col, int threshold){
        int sum = 0;
        while(row != 0){
            sum += row%10;
            row = row/10;
        }
        while(col != 0){
            sum += col%10;
            col = col/10;
        }
        if(sum<=threshold) return true;
        return false;
    }
    public static void main(String[] args) {
        movingCount s = new movingCount();
        System.out.println(s.movingCount(2, 2, 2));
    }
}
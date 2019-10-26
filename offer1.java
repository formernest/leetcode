public class offer1 {
    // 二维数组中的查找
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        if(m == 0) return false;
        int n = array[0].length;
        int row = m-1, col = 0;
        while(row>=0 && col<n){
            if(array[row][col] == target) return true;
            if(array[row][col] > target) {
                row--;
            }else{
                col++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int target = 16;
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        offer1 solution = new offer1();
        System.out.println(solution.Find(target, array));
    }
}
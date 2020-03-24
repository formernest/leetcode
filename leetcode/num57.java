class num57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int left = newInterval[0];
        int right = newInterval[1];
        for(int i=0; i<m; i++){
            if(left>intervals[i][1]){
                continue;
            }else if(right < intervals[i][0]){
                
            }
        }
    }
}
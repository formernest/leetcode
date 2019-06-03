class num202 {
    public boolean isHappy(int n) {
        String s = Integer.toString(n);
        int sum = cal_sum(s);
        while(sum!=1){
            sum = cal_sum(Integer.toString(sum));
        }
        
    }
    public static int cal_sum(String s){
        int sum = 0;
        for(int i = 0; i< s.length(); i++){
            int temp = Integer.parseInt(s.charAt(i).toString);
            sum += temp*temp;
        }
        return sum;
    }
}
class num263 {
    public boolean isUgly(int num) {
        int[] items = {2, 3, 5};
        for(int item:items){
            while(num % item == 0 && num > 0){
                num /= item;
            }
        }
        return num == 1;
    }
}
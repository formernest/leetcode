public class reOrderArray {
    public void reOrderArray(int [] array) { // 冒泡排序
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j]%2==0 && array[j+1]%2==1){  // 每次交换
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }
    // 1,2,3,4,5,6,7,8
    // 1,3,2,5,4,7,6,8
    // 1,3,5,2,7,4,6,8
    // 1,3,5,7,2,4,6,8
}
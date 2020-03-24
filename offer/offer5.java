public class offer5 {
    // 旋转数组的最小数字
    public int minNumberInRotateArray(int[] array) {
        int length = array.length;
        if(length == 0) return 0;
        if(length == 1) return array[0];
        for(int i=1; i<array.length-1; i++){
            if(array[i] == array[i-1]){
                continue;
            }else if(array[i]<array[i-1]){
                return array[i];
            }
        }
        return array[length-1];
    }
}
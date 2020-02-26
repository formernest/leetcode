
public class temp{
    public int  quicksort(int[] arr, int left, int right){
        if(left<right){
            int index = partition(arr, 0, arr.length-1);
            quicksort(arr, 0, index-1);
            quicksort(arr, index+1, arr.length-1);
        }
        return arr[arr.length/2];
    }
    public int partition(int[] arr, int left, int right){
        int p = left;
        int index = left+1;
        for(int i=index; i<=right; i++){
            if(arr[i] < arr[p]){
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                index += 1;
            }
        }
        int temp = arr[p];
        arr[p] = arr[index-1];
        arr[index-1] = temp;
        return index-1;
    }
}
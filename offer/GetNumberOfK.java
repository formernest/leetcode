public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        int i=0;
        while(i<array.length && array[i] < k) i++;
        while(i<array.length && array[i] == k){
            count++;
            i++;
        }
        return count;
    }
}
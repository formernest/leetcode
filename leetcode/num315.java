import java.util.ArrayList;
import java.util.List;

class num315 {
    public int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        count = new int[nums.length];
        int[] indexs = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            indexs[i] = i;
        }
        mergeSort(nums, indexs, 0, nums.length-1);
        for(int n:count) res.add(n);
        return res;
    }
    public void mergeSort(int[] nums, int[] indexs, int left, int right){
        if(left >= right) return;
        int mid = (right-left) / 2 + left;
        mergeSort(nums, indexs, left, mid);
        mergeSort(nums, indexs, mid+1, right);
        merge(nums, indexs,left, right);
    }
    public void merge(int[] nums, int[] indexs, int left, int right){
        int[] new_indexs = new int[right-left+1];
        int index = 0;
        int mid = (right - left) / 2 + left;
        int i = left;
        int j = mid+1;
        int rightcount = 0;
        while(i<=mid && j<=right){
            if(nums[indexs[j]] < nums[indexs[i]]){
                new_indexs[index++] = indexs[j++];
                rightcount ++;
            }else{
                new_indexs[index++] = indexs[i];
                count[indexs[i]] += rightcount;
                i++;
            }
        }
        while(i <= mid){
            new_indexs[index++] = indexs[i];
            count[indexs[i]] += rightcount;
            i++;
        }
        while(j<=right){
            new_indexs[index++] = indexs[j++];
        }
        for(int k=0; k<new_indexs.length; k++){
            indexs[left + k] = new_indexs[k];
        }
    }
}
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return heap(nums, k);

    }
    public int heap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num:nums){
            if(heap.size() < k) heap.offer(num);
            else{
                if(num > heap.peek()){
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        return heap.peek();
    }
    public int quickSort(int[] nums, int k) {
        int id = partition(nums, 0, nums.length-1, nums.length-k);
        return nums[id];
    }
    public int partition(int[] nums, int left, int right, int k){
        int i = left - 1;
        int pivot = nums[right];
        for(int j=left; j<=right; j++){
            if(nums[j]<pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        if(i==k) return i;
        else if(i<k) return partition(nums, i+1, right, k);
        else return partition(nums, left, right-1, k);
    }
}
package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 *  You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
    Example:
    Input: [5,2,6,1]
    Output: [2,1,1,0] 
    Explanation:
    To the right of 5 there are 2 smaller elements (2 and 1).
    To the right of 2 there is only 1 smaller element (1).
    To the right of 6 there is 1 smaller element (1).
    To the right of 1 there is 0 smaller element.
思路：
    记录数组的索引、创建索引数组，对索引数组进行归并排序
    合并的时候分为：left列表和right列表
    当right列表中的数字比较小，则从right列表中复制一个数字到新数组中，则表明有小数字前移了，则rightcount++
    当left列表中的数字比较小，则从left列表中复制一个数字到新数组中，且根据这个数字的索引增加rightcount
    即count[ index of the number ] += rightcount，这是这轮合并在其右边且比他小的那些数字的数目之和。
 */
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
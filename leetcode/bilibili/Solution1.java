package leetcode.bilibili;

public class Solution1 {
    public int GetMaxConsecutiveOnes(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        int size = arr.length;
        while (right < size) {
            count += arr[right] == 0 ? 1 : 0;
            while (count > k) {
                count -= arr[left] == 0 ? 1 : 0;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}

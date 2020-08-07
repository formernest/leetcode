package leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)). You may assume nums1 and nums2 cannot be both empty.
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0
 */
class num4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 中间的两个数，如果是奇数算两次
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left)
                + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让len1始终小于len2
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        // 如果最小的len等于0，则中位值肯定在nums2中
        if (len1 == 0)
            return nums2[start2 + k - 1];
        // 如果是第1个数，返回最小的
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        // 每次排除k/2个数
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        // 如果nums1中第k/2个数大，则截取nums2的一半，否则，相反
        if (nums1[i] > nums2[j])
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        else
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }
}
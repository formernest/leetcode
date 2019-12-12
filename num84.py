#!/usr/bin/python3.6
# -*- coding: utf-8 -*-
# @Time    : 2019-12-11 17:30
# @Author  : flee


class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if len(heights) == 0:
            return 0
        if len(heights) == 1:
            return heights[0]
        heights = heights + [0]
        max_area = heights[0]
        for i in range(0, len(heights)-1):
            if heights[i] <= heights[i+1]:
                continue
            else:
                j = i
                min_height = heights[i]
                while j >= 0:
                    min_height = min(heights[j], min_height)
                    temp = min_height * (i-j+1)
                    max_area = max(max_area, temp)
                    j -= 1
        return max_area


if __name__ == '__main__':
    heights = [2,1,5,6,2,3]
    s = Solution()
    print(s.largestRectangleArea(heights))





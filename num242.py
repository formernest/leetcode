class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        if sorted(s) != sorted(t):
            return False
        return True


if __name__ == '__main__':
    s = "rat"
    t = "cat"
    solution = Solution()
    print(solution.isAnagram(s, t))

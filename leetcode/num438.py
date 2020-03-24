class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        pdict = {}
        for item in p:
            if item in pdict:
                pdict[item] += 1
            else:
                pdict[item] = 1
        dict_len = len(pdict)
        length = len(p)
        temp = {}
        formerd = 0
        for i in range(len(s)):
            if s[i] in temp:
                temp[s[i]] += 1
            else:
                temp[s[i]] = 1
            if s[i] in pdict and temp[s[i]] == pdict[s[i]]:
                formerd += 1
            if i >= length-1:
                if formerd == dict_len:
                    res.append(i-length+1)
                temp[s[i-length+1]] -= 1
                if s[i-length+1] in pdict and temp[s[i-length+1]] == pdict[s[i-length+1]]-1:
                    formerd -= 1
        return res


if __name__ == "__main__":
    solution = Solution()
    s = "cbaebabacd"
    p = "abc"
    print("s length:", len(s), "p length:", len(p))
    print(solution.findAnagrams(s, p))
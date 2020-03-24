class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        maps = [0 for _ in range(26)]
        for item in tasks:
            maps[ord(item) - ord('A')] += 1
        maps = sorted(maps)
        max_value = maps[25] - 1
        idle_slots = max_value * n
        for i in range(24, -1, -1):
            if maps[i] > 0:
                idle_slots -= min(maps[i] , max_value)
            else:
                break
        if idle_slots > 0:
            return len(tasks) + idle_slots
        else:
            return len(tasks)

if __name__ == "__main__":
    solution = Solution()
    tasks = ["A","A","A","B","B","B"]
    n = 2
    print(solution.leastInterval(tasks, n))
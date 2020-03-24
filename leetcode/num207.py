class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if prerequisites is None:
            return False
        if numCourses == 0 or len(prerequisites) == 0:
            return True
        graph = [[] for i in range(numCourses)]
        preNum = [0 for i in range(numCourses)]
        for item in prerequisites:
            graph[item[1]].append(item[0])
            preNum[item[0]] += 1
        queue = []
        for i in range(numCourses):
            if preNum[i] == 0:
                queue.append(i)
        while len(queue) != 0:
            item1 = queue[0]
            queue.remove(item1)
            for item2 in graph[item1]:
                preNum[item2] -= 1
                if preNum[item2] == 0:
                    queue.append(item2)
        for item in preNum:
            if item != 0:
                return False
        return True
            
if __name__ == "__main__":
    numCourses = 2
    prerequisites = [[1,0], [0, 1]]
    solution = Solution()
    print(solution.canFinish(numCourses, prerequisites))

        
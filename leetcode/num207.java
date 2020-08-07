package leetcode;
import java.util.LinkedList;
/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
    Example 1:
    Input: 2, [[1,0]] 
    Output: true
    Explanation: There are a total of 2 courses to take. 
                To take course 1 you should have finished course 0. So it is possible.
    Example 2:
    Input: 2, [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
                To take course 1 you should have finished course 0, and to take course 0 you should
                also have finished course 1. So it is impossible.

    思路：
    用拓扑排序算法的过程来对课程依赖关系进行排序、若排序之后剩余课程数为0，则证明可进行拓扑排序，否则不然
 */
class num207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int[] item:prerequisites){
            int start = item[0];
            int end = item[1];
            matrix[end][start] += 1;
            indegree[start] += 1;
        }
        LinkedList<Integer> queue = new LinkedList();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int peek = queue.removeFirst();
            numCourses -= 1;
            for(int i=0; i<indegree.length; i++){
                if(matrix[peek][i] == 1){
                    indegree[i] -= 1;
                    if(indegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}
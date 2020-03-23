import java.util.LinkedList;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int peek = queue.removeFirst();
            res[index++] = peek;
            for(int i=0; i<indegree.length; i++){
                if(matrix[peek][i] == 1){
                    indegree[i] -= 1;
                    if(indegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        return index == numCourses? res:new int[0];
    }
}
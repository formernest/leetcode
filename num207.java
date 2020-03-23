import java.util.LinkedList;

class Solution {
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
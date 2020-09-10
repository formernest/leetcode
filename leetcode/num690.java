package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee emp = null;
        int sum = 0;
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        // 广度优先算法遍历
        ArrayDeque<Employee> queue = new ArrayDeque<Employee>();
        queue.addLast(map.get(id));
        while(!queue.isEmpty()){
            emp = queue.removeFirst();
            sum += emp.importance;
            for(int i:emp.subordinates){
                queue.addLast(map.get(i));
            }
        }
        return sum;
    }
}
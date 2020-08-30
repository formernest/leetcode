package interview;

/**
 * 程序员面试：派对的最大快乐值
 * 要求：如果某个员工来了，其直接下属不能来。
 * 分析：
 * 1、如果某个员工来了，则这个员工的所有下属都不能来
 * 2、如果某个员工不来，则这个员工的下属可来可不来
 */
import java.util.LinkedList;
import java.util.List;

class Employee {
    int happy;
    List<Employee> workers = new LinkedList<Employee>();
}

class ReturnType {
    public int yes;
    public int no;

    public ReturnType(int yes, int no) {
        this.yes = yes;
        this.no = no;
    }
}

public class maxHappy {
    public int getMaxHappy(Employee boss) {
        ReturnType data = process(boss);
        return Math.max(data.yes, data.no);
    }

    public ReturnType process(Employee boss) {
        int yesMax = boss.happy;
        int noMax = 0;
        if (boss.workers.isEmpty()) {
            return new ReturnType(yesMax, noMax);
        } else {
            for (Employee item : boss.workers) {
                ReturnType worker = process(item);
                yesMax += worker.no;
                noMax += Math.max(worker.yes, worker.no);
            }
            return new ReturnType(yesMax, noMax);
        }
    }
}
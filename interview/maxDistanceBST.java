package interview;

/**
 * 程序员面试：二叉树之间的最大距离，二叉树之间的距离为起点和终点之间的最大节点数量。 思路：树dp 一、分析可能性 1、最大距离为左子树
 * 2、最大距离在右子树 3、最大距离为左子树根节点和右子树 二、分析需要的信息 需要的信息包括子树中的最大高度和最大距离 三、整合需要的信息
 * 四、设计递归树dp
 */
class ReturnType {
    int maxDiatance;
    int height;

    public ReturnType(int height, int level) {
        this.maxDiatance = height;
        this.height = level;
    }
}

public class maxDistanceBST {
    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 1);
        }
        ReturnType lh = process(head.left);
        ReturnType rh = process(head.right);
        int height = Math.max(lh.height, rh.height) + 1;
        int level = Math.max(lh.height + rh.height + 1, Math.max(lh.maxDiatance, rh.maxDiatance));
        return new ReturnType(height, level);
    }

    public int maxHeight(Node head) {
        return process(head).maxDiatance;
    }
}
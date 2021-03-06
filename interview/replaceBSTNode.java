package interview;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 找出二叉搜索树中的两个错误节点
 * 方法：中序遍历【搜索树中序遍历为递增顺序】
 * 例子：1-2-3-4-5 -> 1-5-3-4-2，错误节点为5，2；
 *      1-2-3-4-5 -> 1-2-4-3-5, 错误节点为4，3；
 * 可能性
 * 1、两个递减序列
 * 2、一个递减序列
 * 求解：找到第一个递减序列的第一个节点，以及最后一个递减序列的最后节点。函数为getErrorNode
 * 
 * 进阶：找到两个错误节点后并进行置换
 * 求解：1、找到两个错误节点。2、找到两个错误节点的父节点和左右子节点。3、连接断开的节点
 */
import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Rela {
    Node parent;
    boolean isLeft;

    public Rela(Node p, boolean isLeft) {
        this.parent = p;
        this.isLeft = isLeft;
    }
}

public class replaceBSTNode {
    public Node[] getErrorNode(Node head) {
        Node[] errors = new Node[2];
        if (head == null) {
            return errors;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        // 中序遍历
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.val > head.val) {
                    errors[0] = errors[0] == null ? pre : errors[0];
                    errors[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errors;
    }

    public void replace(Node head) {
        Node[] errors = getErrorNode(head);
        Rela[] parents = getParent(errors, head);
        Node p1 = parents[0].parent;
        Node son1 = errors[0].left;
        Node son2 = errors[0].right;
        if (parents[0] == null) {
            if (parents[1].isLeft) {
                parents[1].parent.left = errors[0];
            } else {
                parents[1].parent.right = errors[0];
            }
        }
    }

    public Rela[] getParent(Node[] nodes, Node head) {
        Rela[] relas = { null, null };
        if (head == nodes[0]) {
            relas[0] = new Rela(null, true);
        } else if (head == nodes[1]) {
            relas[1] = new Rela(null, true);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (relas[0] != null && relas[1] != null) {
            Node p = queue.poll();
            if (p.left == nodes[0]) {
                relas[0] = new Rela(p, true);
            } else if (p.right == nodes[0]) {
                relas[0] = new Rela(p, false);
            } else if (p.left == nodes[0]) {
                relas[1] = new Rela(p, true);
            } else if (p.right == nodes[1]) {
                relas[1] = new Rela(p, false);
            }
        }
        return relas;
    }
}
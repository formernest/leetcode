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

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class Rela{
    Node parent;
    boolean isLeft;
    public Rela(Node p, boolean isLeft){
        this.parent = p;
        this.isLeft = isLeft;
    }
}
public class replaceBSTNode{
    public Node[] getErrorNode(Node head){
        Node[] errors = new Node[2];
        if(head == null){
            return errors;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        // 中序遍历
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                if(pre != null && pre.val > head.val){
                    errors[0] = errors[0] == null ? pre:errors[0];
                    errors[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errors;
    }
}
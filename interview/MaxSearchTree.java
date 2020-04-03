package interview;
/**
 * 查找一棵树中的最大二叉搜索树，即最大的符合二叉搜索规则的树。
 * 方法：树形dp + 递归 
 * 一、分析可能的情况
 * 1、最大搜索树在root的左子树中
 * 2、最大搜索树在root的右子树中
 * 3、最大搜索树是root为根节点的树
 * 二、分析需要的信息
 * 1、最大搜索树的size
 * 2、最大搜索树的头结点
 * 3、最大搜索树的最大值
 * 4、最大搜索树的最小值
 * 最大值和最小值为了整合一中的第三种情况。
 * 三、合并信息形成一个类
 * 四、设计递归函数
 * 解题过程：
 * 1、定义ReturnType
 * 2、设计递归函数分别遍历左右子树，整合信息得出ReturnType
 * 3、整合两种情况分析第三种可能性
 * 4、返回整合的结果
 */
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
class ReturnType{
    int min;
    int max;
    int BSTSize;
    Node BSTHead;
    public ReturnType(int min, int max, int size, Node head){
        this.min = min;
        this.max = max;
        this.BSTSize = size;
        this.BSTHead = head;
    }
}
public class MaxSearchTree{
    public Node getMaxBST(Node root){
        return process(root).BSTHead;
    }
    public ReturnType process(Node root){
        if(root == null){
            return new ReturnType(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, root);
        }
        ReturnType lData = process(root.left);
        ReturnType rData = process(root.right);
        // 最小值和最大值为整合得出最后一种可能性服务，不影响前面两种可能的结果
        int min = Math.min(root.val, Math.min(lData.min, rData.min));
        int max = Math.max(root.val, Math.max(lData.max, rData.max));
        int maxSize = Math.max(lData.BSTSize, rData.BSTSize);
        Node maxHead = lData.BSTSize > rData.BSTSize? lData.BSTHead:rData.BSTHead;
        if(lData.BSTHead == root.left && rData.BSTHead == root.right && root.val > lData.max && root.val < rData.min){
            maxSize = lData.BSTSize + rData.BSTSize + 1;
            maxHead = root;
        }
        return new ReturnType(min, max, maxSize, maxHead);
    } 
}
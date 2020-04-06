package interview;

import java.util.LinkedList;
import java.util.List;

/**
 * 程序员面试：统计和生成所有的不同二叉搜索树
 * 思路：dp
 * 对每一个可以当做根节点的元素，其左子树的个数是小于当前元素可以组成的二叉树数量，右子树是大于当前元素的二叉树数量。
 * 使用动态规划的方法记录当前值作为根节点可以有的最大二叉树数量
 * 
 */
public class numOfBST{
    public static int getNum(int n){
        if(n < 2){
            return 1;
        }
        int[] nums = new int[n+1];
        nums[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                nums[i] += nums[j] * nums[i-j-1];
            }
        }
        return nums[n];
    }
    public List<Node> generate(int n){
        return gen_help(1, n);
    }
    public List<Node> gen_help(int start, int end){
        List<Node> result = new LinkedList<>();
        if(start > end){
            return null;
        }
        Node head = null;
        for(int i=start; i<=end; i++){
            head = new Node(i);
            List<Node> left = gen_help(start, i-1);
            List<Node> right = gen_help(i+1, end);
            for(Node item_left:left){
                for(Node item_right:right){
                    head.left = item_left;
                    head.right = item_right;
                    result.add(clone(head));
                }
            }
        }
        return result;
    }
    public Node clone(Node head){
        if(head == null){
            return null;
        }
        Node res = new Node(head.val);
        head.left = clone(head.left);
        head.right = clone(head.right);
        return res;
    }
    public static void main(String[] args) {
        int n = 2;
        int result = getNum(n);
        System.out.println(result);
    }
}
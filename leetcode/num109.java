package leetcode;
/**
 * 有序链表转化为二叉搜索树
 */
public class num109 {
    public static TreeNode sortedListToBST(ListNode head) {
        return construct(head);
    }

    // 获得中间节点的前一个节点
    private static ListNode getRoot(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

    private static TreeNode construct(ListNode head) {
        ListNode rootNode = getRoot(head);
        if (rootNode == null)
            return head == null ? null : new TreeNode(head.val);
        TreeNode root = new TreeNode(rootNode.val);
        ListNode right = rootNode.next;
        if (right != null)
            root.right = construct(right);
        if (head != null && rootNode != head)
            root.left = construct(head);
        return root;
    }

    public static void main(String[] args) {
        int[] items = { -10, -3, 0, 5, 9 };
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int item : items) {
            p.next = new ListNode(item);
            p = p.next;
        }
        TreeNode root = sortedListToBST(head.next);
        System.out.println(root.val);
        System.out.println(root.left.left.val);
        System.out.println(root.right.left.val);
    }
}
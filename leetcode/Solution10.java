package leetcode;

import java.util.LinkedList;

public class Solution10 {
    public ListNode reverse(ListNode node) {
        ListNode head = new ListNode(0);
        ListNode p = node;
        while (p != null) {
            ListNode temp = p.next;
            ListNode next = head.next;
            head.next = p;
            p.next = next;
            p = temp;
        }
        return head.next;
    }

    public void travelZ(TreeNode node) {
        LinkedList<TreeNode> list = new LinkedList<>();
        boolean flag = true;
        list.addLast(node);
        while (!list.isEmpty()) {
            if (flag) {
                int size = list.size();
                while (size-- > 0) {
                    TreeNode root = list.pollFirst();
                    if (root.left != null) {
                        list.addLast(root.left);
                    }
                    if (root.right != null) {
                        list.addLast(root.right);
                    }
                    System.out.println(root.val + " ");
                }
                flag = false;
            } else {
                int size = list.size();
                while (size-- > 0) {
                    TreeNode root = list.pollLast();
                    if (root.right != null) {
                        list.addFirst(root.right);
                    }
                    if (root.left != null) {
                        list.addFirst(root.left);
                    }
                    System.out.print(root.val + " ");
                }
                flag = true;
            }
            System.out.println();
        }
    }
}
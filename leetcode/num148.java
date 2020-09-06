package leetcode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);
        return mergeList(node1, node2);
    }

    public ListNode mergeList(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        while (node1 != null) {
            p.next = node1;
        }
        while (node2 != null) {
            p.next = node2;
        }
        return dummy.next;
    }
}

package leetcode;

class num83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode pre = head;
        while (p != null) {
            while (p.next != null && p.next.val == p.val)
                p = p.next;
            p = p.next;
            pre.next = p;
            pre = p;
        }
        return head;
    }
}
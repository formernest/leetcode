package leetcode;

public class num25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = size(head);
        if (size < k)
            return head;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        int n = 0;
        while (n < k && cur != null) { // reverse k nodes
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n++;
        }
        if (cur != null) {
            head.next = reverseKGroup(cur, k);
        }
        return pre;
    }

    public int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size += 1;
            head = head.next;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        num25 s = new num25();
        head = s.reverseKGroup(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
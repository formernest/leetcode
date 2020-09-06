package leetcode;

public class num23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        boolean flag = true;
        int min;
        int index;
        while (flag) {
            min = 999;
            index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (min > lists[i].val) {
                        min = lists[i].val;
                        index = i;
                    }
                }
            }
            if (index == -1) {
                flag = false;
            } else {
                p.next = lists[index];
                p = p.next;
                lists[index] = lists[index].next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] list = new ListNode[] { l1, l2, l3 };
        num23 s = new num23();
        ListNode head = s.mergeKLists(list);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
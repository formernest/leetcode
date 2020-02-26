class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class num82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode newList = null;
        ListNode pre = null;

        while (curr != null) {
            // 当前节点的前一个节点与当前节点的下一个节点都不相等则插入新链表中
            if ((pre == null || pre.val != curr.val) && (curr.next == null || curr.val != curr.next.val)) {
				 if (newList == null) {
					newList = curr;
                    head = newList;
                } else {
                    newList.next = curr;
                    newList = newList.next;
                }
            }
			pre = curr;
            curr = curr.next;
        }

        if (newList != null) {
            newList.next = null;
            return head;
        }

        return newList;
    }
}
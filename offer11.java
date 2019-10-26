
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class offer11 {
    // 删除链表中重复的节点
    public ListNode deleteDuplication(ListNode pHead)
    {
        int count = 0;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur.next!=null){
            while(cur.val == cur.next.val){
                cur = cur.next;
                count ++; 
            }
            if(count == 0){
                pre.next = cur;
                pre = cur;
                count = 0;
            }
            cur = cur.next;
        }
        return head;
    }
}
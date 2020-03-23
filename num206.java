
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }
        return p;
    }
}
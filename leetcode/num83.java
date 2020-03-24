class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode pre = head;
        while(p!=null){
            while(p.next!=null && p.next.val == p.val) p = p.next;
            p = p.next;
            pre.next = p;
            pre = p;
        }
        return head;
    }
}
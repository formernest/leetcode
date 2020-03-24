class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p=head, q=head;
        int i=0;
        for(; p!=null; i++){
            if(i>=k){
                q = q.next;
            }
            p = p.next;
        }
        return i<k? null:q;
    }
}
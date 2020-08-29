package daily_problem;

public class MergeLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        ListNode head = lists[0];
        for(int i=1; i<lists.length; i++){
            head = merge(head, lists[i]);
        }
        return head;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode p=new ListNode(0);
        ListNode head = p;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return head.next;
    }
}
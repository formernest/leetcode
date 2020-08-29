

public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode low = pHead;
        ListNode fast = pHead;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
            if(fast == low) break;
        }
        if(fast == null || fast.next == null) return null;
        low = pHead;
        while(fast != low){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}
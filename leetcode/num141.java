import java.util.HashSet;
import java.util.Set;


 
public class num141 {
    // hash
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> map = new HashSet<>();
        ListNode p = head;
        while(p!=null){
            if(map.contains(p)){
                return true;
            }else{
                map.add(p);
            }
            p = p.next;
        }
        return false;
    }
    // two pointer
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
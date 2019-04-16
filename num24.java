
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class num24 {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        while(head!=null){
            if(head.next!=null){
                p.next = head.next;
                p = p.next;
            }
            p.next = head;
            p = p.next;
            if(head.next.next!=null){
                head = head.next.next;
            }else{
                head = null;
            }    
        }
        return result.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        num24 s = new num24();
        ListNode result = s.swapPairs(head);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }        
    }
}
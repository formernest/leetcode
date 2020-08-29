
public class num147 {
    public ListNode insertionSortList(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }
       ListNode dummy = new ListNode(0);
       while(head!=null){
           ListNode cur = dummy;
           while(cur.next!=null && cur.next.val<head.val){
               cur = cur.next;
           }
           ListNode tmp = cur.next;
           cur.next = head;
           head = head.next;
           cur.next.next = tmp;
       }
       return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        num147 s = new num147();
        ListNode result = s.insertionSortList(head);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
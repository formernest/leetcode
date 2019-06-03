class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class num86 {
    public static ListNode partition(ListNode head, int x) {
       ListNode before_head = new ListNode(0);
       ListNode before = before_head;
       ListNode after_head = new ListNode(0);
       ListNode after = after_head;
       while(head!=null){
            if(head.val<x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
       }
       after.next = null;
       before.next = after_head.next;
       return before_head.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode root = partition(head, 3);
        while(root!=null){
            System.out.println(root.val);
            root = root.next;
        }
    }
}
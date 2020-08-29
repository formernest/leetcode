import java.util.List;

 
public class num61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = 0;
        ListNode p = head;
        while(p != null){
            len += 1;
            p = p.next;
        }
        if(k%len == 0) return head;
        int count = len - k%len;
        p = head;
        while(count-1 > 0){
            count -= 1;
            p = p.next;
        }
        ListNode right = p.next;
        ListNode s = right;
        p.next = null;
        while(right.next!=null){
            right = right.next;
        }
        right.next = head;
        return s;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int k = 2;
        ListNode p = head;
        for(int i=2; i<6; i++){
            p.next = new ListNode(i);
            p = p.next;
        }
        num61 solution = new num61();
        ListNode result = solution.rotateRight(head, k);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
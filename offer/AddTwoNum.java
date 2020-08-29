
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode p=l1, q=l2;
        while(p!=null || q!=null){
            int x=(p!=null)? p.val:0;
            int y=(q!=null)? q.val:0;
            int val = x + y + carry;
            int current = val%10;
            carry = val/10;
            curr.next=new ListNode(current);
            curr = curr.next;
            if (p!=null) p = p.next;
            if (q!=null) q = q.next;
        }
        if(carry > 0 ){
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
    public static void main(String[] args) {
        int[] num1 = new int[]{2, 4, 3};
        int[] num2 = new int[]{5, 6, 4};
        ListNode l1 = new ListNode(num1[0]);
        ListNode p1 = l1;
        ListNode l2 = new ListNode(num2[0]);
        ListNode p2 = l2;
        for(int i=1;i<num1.length;i++){
            p1.next = new ListNode(num1[i]);
            System.out.println(p1.val);
            p1 = p1.next;
        }
        for(int i=1;i<num2.length;i++){
            p2.next = new ListNode(num2[i]);
            System.out.println(p2.val);
            p2 = p2.next;
        }
        AddTwoNum s = new AddTwoNum();
        ListNode l = s.addTwoNumbers(l1, l2);
        while(l.next!=null){
            System.out.println(l.val);
            l = l.next;   
        }
        System.out.println(l.val);
    }
}
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty()){
            int i = 0, j = 0;
            if(!s1.isEmpty()) i = s1.pop();
            if(!s2.isEmpty()) j = s2.pop();
            sum = i + j + carry;
            int temp = sum % 10;
            carry = sum / 10;
            ListNode next = dummy.next;
            ListNode cur = new ListNode(temp);
            dummy.next = cur;
            cur.next = next;
        }
        if(carry != 0){
            ListNode temp = dummy.next;
            ListNode p = new ListNode(carry);
            p.next = temp;
            dummy.next = p;
        }
        return dummy.next;
    }
}
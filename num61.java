import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode p = head;
        while(p != null){
            len += 1;
            p = p.next;
        }
        if(k%len == 0) return head;
        int count = len - k%len;
        p = head;
        while(count >= 0){
            
        }
    }
}
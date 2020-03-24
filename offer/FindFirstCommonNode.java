class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0;
        int length2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=null){
            length1 += 1;
            p1=p1.next;
        }
        while(p2!=null){
            length2 += 1;
            p2=p2.next;
        }
        int diff = length1 - length2;
        p1 = pHead1;
        p2 = pHead2;
        if(diff > 0){     
            while(diff >0){
                p1 = p1.next;
                diff -= 1;
            }
        }else{            
            while(diff < 0){
                p2 = p2.next;
                diff += 1;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
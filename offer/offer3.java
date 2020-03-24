import java.util.ArrayList;
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class offer3 {
    // 从尾到头打印链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode pre = null;
        ListNode cur = listNode;
        while(cur!=null){
            ListNode curtemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curtemp;
        }
        while(pre!=null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        offer3 solution = new offer3();
        ArrayList<Integer> newHead = solution.printListFromTailToHead(node1);
        for(Integer i:newHead){
            System.out.println(i);
        }
    }
}
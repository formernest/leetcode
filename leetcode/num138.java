package leetcode;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class num138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node pre = head, p = head;
        while (pre != null) {
            Node temp = pre.next;
            Node q = new Node(pre.val, pre.next, null);
            pre.next = q;
            q.next = temp;
            pre = temp;
        }
        while (p != null) {
            Node q = p.next;
            if (p.random != null) {
                q.random = p.random.next;
            }
            p = q.next;
        }
        Node s = new Node(0, null, null);
        Node s1 = s;
        while (head != null) {
            Node q = head.next;
            head.next = q.next;
            s.next = q;
            head = q.next;
            s = q;
        }
        return s1.next;
    }
}
package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 程序员面试[再看一遍]
 * 二叉搜索树的最大拓扑
 */
// 记录当前节点左子树的最大拓扑数+右子树的最大拓扑数
class Record{
    int l;
    int r;
    public Record(int left, int right){
        l = left;
        r = right;
    }
}
public class maxBSTTopo{
    public int TopoSize(Node head){
        Map<Node, Record>  map = new HashMap<>();
        return posOrder(head, map);
    }
    public int posOrder(Node head, Map<Node, Record> map){
        if(head == null) return 0;
        int ls = posOrder(head.left, map);
        int rs = posOrder(head.right, map);
        modifyMap(head.left, head.val, map, true);
        modifyMap(head.right, head.val, map, false);
        Record lr = map.get(head.left);
        Record rr = map.get(head.right);
        int lbst = lr == null? 0:lr.l+lr.r+1;
        int rbst = rr == null? 0:rr.l+rr.r+1;
        map.put(head, new Record(lbst, rbst));
        return Math.max(lbst+rbst+1, Math.max(ls, rs));      
    }
    public int modifyMap(Node node, int value, Map<Node, Record> map, boolean isLeft){
        if(node == null || !map.containsKey(node)){
            return 0;
        }      
        Record r = map.get(node);
        if((isLeft && node.val>value) || (!isLeft && node.val < value)){
            map.remove(node);
            return r.l + r.r + 1;
        }else{
            int minus = modifyMap(isLeft? node.right:node.left, value, map, isLeft);
            if(isLeft) r.r = r.r - minus;
            else r.l = r.l - minus;
            map.put(node, r);
            return minus;
        }
    }
}
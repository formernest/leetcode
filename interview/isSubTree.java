package interview;
/**
 * 程序员面试
 * 判断tree2是否为tree1的子树
 * 方法：序列化+KMP
 * 解法：序列化tree1和tree2, 这样tree2就是tree1的一个子序列。序列化使用前序遍历，匹配使用KMP算法
 */
public class isSubTree{
    public boolean isSub(Node node1, Node node2){
        String str1 = serialByPre(node1);
        String str2 = serialByPre(node2);
        return getIndexOf(str1, str2) != -1;
    }
    public String serialByPre(Node node){
        if(node == null) return "#!";
        String res = node.val + "!";
        res += serialByPre(node.left);
        res += serialByPre(node.right);
        return res;
    }
    public int getIndexOf(String str1, String str2){
        if(str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()){
            return -1;
        }
        char[] ss = str1.toCharArray();
        char[] ms = str2.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next2 = getNext(ms);
        // match
        while(si<ss.length && mi<ms.length){
            if(ss[si] == ms[mi]){
                si++;
                mi++;
            }else if(next2[mi] == -1){
                si ++;
            }else{
                mi = next2[mi];
            }
        }
        return mi == ms.length? si-mi:-1;
    }
    // KMP get next
    public int[] getNext(char[] ms){
        if(ms.length == 1) return new int[]{-1};
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos < ms.length){
            if(ms[pos-1] == ms[cn]){
                next[pos++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }
        return next;
    }
}
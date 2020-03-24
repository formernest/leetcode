public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return isTreeBST(sequence, 0, sequence.length-1);
    }
    public boolean isTreeBST(int[] sequence, int start, int end){
        if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;   // 找到左子树中的所有节点
        }
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;   // 检查右子树是否所有的节点值都大于根节点
        }
        return isTreeBST(sequence, start, i-1) && isTreeBST(sequence, i, end-1); //检查左子树与右子树
    }
}
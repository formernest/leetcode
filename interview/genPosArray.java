package interview;

/**
 * 程序员面试：通过先序和中序数组生成后序数组
 * 
 */
import java.util.HashMap;
import java.util.Map;

public class genPosArray {
    public static int[] getPosArr(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int length = pre.length;
        int[] post = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, length - 1, in, 0, length - 1, post, length - 1, map);
        return post;
    }

    // 设置当前状态下的后序遍历的索引，返回值为下一次遍历的根节点应该放置的索引位置。
    public static int setPos(int[] pre, int start, int end, int[] in, int inStart, int inEnd, int[] post, int index,
            Map<Integer, Integer> map) {
        if (start > end) {
            return index;
        }
        post[index--] = pre[start];
        int in_index = map.get(pre[start]);
        // 设置遍历右子树后的index
        index = setPos(pre, end - inEnd + in_index + 1, end, in, in_index + 1, inEnd, post, index, map);
        // 设置遍历左子树后的index
        return setPos(pre, start + 1, in_index - inStart + start, in, inStart, in_index - 1, post, index, map);
    }

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
        int[] in = { 4, 2, 5, 1, 6, 3, 7 };
        int[] post = getPosArr(pre, in);
        for (int item : post) {
            System.out.println(item);
        }
    }
}
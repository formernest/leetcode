package interview;
/**
 * [程序员面试]：加油站的良好出发点
 */
public class goodStart {
    public boolean[] stations(int[] dis, int[] oils) {
        if (dis == null || oils == null || dis.length != oils.length) {
            return null;
        }
        int init = changeDisArray(dis, oils);
        return init == -1 ? new boolean[dis.length] : enLargeArea(dis, init);
    }

    private boolean[] enLargeArea(int[] dis, int init) {
        boolean[] result = new boolean[dis.length];
        int start = init;
        int end = nextIndex(init, dis.length);
        int rest = 0;
        int need = 0;
        while (start != init) {
            if (start != init && start == lastIndex(end, dis.length)) {
                break;
            }
            if (dis[start] < need) {
                need -= dis[start];
            } else {
                rest += dis[start] - need;
                need = 0;
                while (rest >= 0 && end != start) {
                    rest += dis[end];
                    end = nextIndex(end, dis.length);
                }
                if (rest >= 0) {
                    result[start] = true;
                    connectGood(dis, lastIndex(start, dis.length), init, result);
                    break;
                }
            }
            start = lastIndex(start, dis.length);
        }
        return result;
    }

    private void connectGood(int[] dis, int start, int init, boolean[] result) {
        int need = 0;
        while (start != init) {
            if (dis[start] < need) {
                need -= dis[start];
            } else {
                result[start] = true;
                need = 0;
            }
            start = lastIndex(start, dis.length);
        }
    }

    private int lastIndex(int end, int length) {
        return end == 0 ? length - 1 : end - 1;
    }

    private int nextIndex(int init, int length) {
        return init == length - 1 ? 0 : init + 1;
    }

    private int changeDisArray(int[] dis, int[] oils) {
        int init = -1;
        for (int i = 0; i < dis.length; i++) {
            dis[i] = oils[i] - dis[i];
            if (dis[i] >= 0) {
                init = i;
            }
        }
        return init;
    }

    public static void main(String[] args) {
        int[] dis = { 4, 2, 0, 4, 5, 2, 3, 6, 2 };
        int[] oils = { 6, 1, 3, 1, 6, 4, 1, 1, 6 };
        goodStart solution = new goodStart();
        boolean[] result = solution.stations(dis, oils);
        for(boolean item : result){
            System.out.println(item);
        }
    }
}

import java.util.Arrays;

public class sort {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 冒泡排序
    public void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 选择排序
    public void selectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    // 插入排序
    public void insertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int pre = i - 1;
            int current = arr[i];
            while (pre >= 0 && arr[pre] > current) {
                arr[pre + 1] = arr[pre];
                pre -= 1;
            }
            arr[pre + 1] = current;
        }
    }

    // 希尔排序
    public void shellSort(int[] arr) {
        int length = arr.length;
        int temp, gap = length / 2;
        while (gap > 0) { // gap 每次都除以2
            for (int i = gap; i < length; i++) { // 每次以gap的间隔移动 交换
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    // 归并排序, 稳定, 需要额外的内存
    public int[] mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2)
            return arr;
        int mid = length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] rigth = Arrays.copyOfRange(arr, mid, length);
        return mergehelp(mergeSort(left), mergeSort(rigth));
    }

    public int[] mergehelp(int[] left, int[] rigth) {
        int[] result = new int[left.length + rigth.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = rigth[j++];
            } else if (j >= rigth.length) {
                result[index] = left[i++];
            } else if (left[i] > rigth[j]) {
                result[index] = rigth[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    // 快速排序，交换排序，不稳定，o(logN)
    public void quickSort(int[] arr) {
        quickHelp(arr, 0, arr.length - 1);
    }

    public void quickHelp(int[] arr, int left, int right) {
        if (left < right) {
            int pviot = division(arr, left, right);
            quickHelp(arr, left, pviot - 1);
            quickHelp(arr, pviot + 1, right);
        }
    }

    public int division(int[] arr, int left, int right) {
        // 设置left的值为轴，找出该值的正确位置，左边为小于轴的值，右边为大于轴的值
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= base) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= base) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        return left;
    }

    // 堆排序
    public void heapSort(int[] arr) {
        // 建立大顶堆，升序使用大顶堆，降序使用小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        // 不断交换堆顶元素和末尾元素的位置，然后调整，使最大元素下沉
        for (int j = arr.length - 1; j >= 1; j--) {
            swap(arr, 0, j);
            adjust(arr, 0, j);
        }
    }

    public void adjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 找出左右孩子节点中最大的
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            // 如果最大的节点值大于父节点，则交换
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        // 根节点的值
        arr[i] = temp;
    }

    // 计数排序
    public void countSort(int[] arr) {

    }

    // 桶排序
    public void bucketSort(int[] arr) {
        int length = 0;
        if (arr.length == 0)
            return;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
    }

    // 基数排序
    public void radixSort(int[] arr) {

    }

    public static void main(String[] args) {
        sort solution = new sort();
        int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
        System.out.println("sort name: shell sort");
        // solution.bubbleSort(arr);
        // solution.selectSort(arr);
        // solution.insertSort(arr);
        // solution.shellSort(arr);
        // solution.quickSort(arr);
        solution.heapSort(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

}
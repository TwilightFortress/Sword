package sword.排序;

/**
 * 冒泡排序，每轮比较都会选出一个最大的，所以是从后向前排序，
 * 时间复杂度为O(n*n),稳定
 * @author yuyang
 * @create 2019-08-08 13:50
 */
public class 冒泡 {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //每轮最后位置依次向前移动
        for (int e = arr.length - 1; e > 0; e--) {
            //从起始位置到最后位置依次比较，选出最大的放在最后
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

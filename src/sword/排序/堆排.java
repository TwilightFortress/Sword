package sword.排序;

/**
 * @author yuyang
 * @create 2019-08-08 13:50
 */
public class 堆排 {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //1.将数组转化成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    //将数组转化为大根堆方式存储
    public static void heapInsert(int[] arr, int index) {
        //当前节点的值大于父节点的值
        while (arr[index] > arr[(index - 1) / 2]) {
            //交换
            swap(arr, index, (index - 1) / 2);
            //当前节点变为父节点的值继续进行判断
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            //取左右孩子中较大孩子的下标
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //出现孩子值大的情况要交换位置，largest记录最大值的下标
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            //交换
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

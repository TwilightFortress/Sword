package sword.排序;

/**
 * @author yuyang
 * @create 2019-08-08 13:50
 */
public class 归并 {
    //static int num = 0;
    //边界条件，调用排序方法
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    //归并排序方法
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1); //取中点位置
        mergeSort(arr, l, mid);    //排序左边
        mergeSort(arr, mid + 1, r); //排序右边
        merge(arr, l, mid, r); //合并排序过程
    }

    /**
     * @param arr 数组
     * @param l   左侧指针
     * @param m   中间位置
     * @param r   右侧指针
     */
    public static void merge(int[] arr, int l, int m, int r) {
        //l到r的长度的数组，合并过程中依次存放数据
        int[] help = new int[r - l + 1];
        //help每次填数字的下标
        int i = 0;
        //左侧起始指针
        int p1 = l;
        //右侧起始指针
        int p2 = m + 1;
        //比较移动过程
        while (p1 <= m && p2 <= r) {
            //a = arr[i++]; 这种形式：先赋值再执行i++的操作
            //help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            if (arr[p1] > arr[p2]) {
                help[i++] = arr[p2++];
                //	]num ++;
            } else
                help[i++] = arr[p1++];
        }
        //最后一定有p1或者p2没有走完
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    private static void Myprint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 8, 5, 3, 7, 1};
        mergeSort(arr);
        Myprint(arr);

    }


}


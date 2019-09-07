package sword.排序;

/**
 * @author yuyang
 * @create 2019-08-08 13:50
 */
public class 快排 {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    //改进的快排：随机选择快排
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //随机选择一个数与最后一个数交换，这样实现了随机选择比较数
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    //经典快排
    public static int partition1(int[] arr, int l, int r) {
        //数组最后一个数作为比较值
        int p = arr[r];

        //小于区域边界
        int less = l - 1;

        for(int i = l; i <= r; i++){
            if(arr[i] <= p){
                swap(arr, ++less, i);
            }
        }
        return less;
    }
    public static int[] partition(int[] arr, int l, int r) {
        //小于区域边界
        int less = l - 1;
        //大于区域边界
        int more = r;

        while (l < more) {
            if (arr[l] < arr[r]) {
                //交换小于区域的下一个数与当前数，然后，小于区域向右移动，l指针向右移动
                swap(arr, ++less, l++);

            } else if (arr[l] > arr[r]) {
                //交换大于区域的前一个数与当前数，然后大于区域向左移动，l指针停在原地
                swap(arr, --more, l);
                //当前数等于划分值，l直接向右移动
            } else {
                l++;
            }
        }
        //最后交换大于区域的最后一个数与大于区域的第一个数
        swap(arr, more, r);

        //返回等于区的下标范围
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort1(int[] arr){
        if(arr == null || arr.length <= 1) return ;
        quickSort1(arr, 0 , arr.length - 1);
    }

    private static void quickSort1(int[] arr, int l, int r) {
        if(l < r){
            int n = part1(arr, l, r);
            quickSort1(arr, l , n - 1);
            quickSort1(arr,  n + 1, r);
        }
    }

    private static int part1(int[] arr, int l, int r) {
        int key = arr[l];
        while(l < r){
            while(l < r && arr[r] > key) {
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= key) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = key;
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,7,8,5,3,2,4,5,67};
        quickSort1(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

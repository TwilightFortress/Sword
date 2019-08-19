package sword.数组;

/**
 * @author yuyang
 * @create 2019-08-11 10:11
 */
public class g数字在排序数组中出现的次数 {
    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length < 1) return 0;
        if (k < array[0] || k > array[array.length - 1]) return 0;
        //1,2,2,2,2,3 k+0.5返回下标5，k-0.5返回下标1
        return findK(array, k + 0.5) - findK(array, k - 0.5);
    }

    /**
     * 当l与r相邻时，m的值取的是l,比如2,3，l取2，因为2.5>2,所以最后l指向3
     * 当l与r相邻时，m的值取的是l,比如1,2，l取2，因为1.5>1,所以最后l指向2
     * @param array
     * @param k
     * @return
     */
    public static int findK(int[] array, double k) {
        int r = array.length - 1;
        int l = 0;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (k < array[m])
                r = m - 1;
            if (k > array[m])
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,4};
        GetNumberOfK(arr, 2);
    }
}

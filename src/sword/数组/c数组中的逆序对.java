package sword.数组;

/**
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 归并排序的思想，每次合并时，从后面开始合并
 * @author yuyang
 * @create 2019-08-08 13:20
 */
public class c数组中的逆序对 {
    /**
     * 1.判断一下边界
     * 2.求解过程参数不是只有一个数组，重载方法
     * 3.返回结果
     * @param arr
     * @return
     */
    public static int InversePairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int num = InversePairs(arr, 0, arr.length - 1);
        return num;
    }

    /**
     * 归并排序思想
     * 1.求出给定数组中点
     * 2.递归求出left逆序对数
     * 3.递归求出right逆序对数
     * 4.求出当前的逆序对数
     * 加和返回
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int InversePairs(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1); //取中点位置
        int left = InversePairs(arr, l, mid);    //排序左边
        int right = InversePairs(arr, mid + 1, r); //排序右边
        int count = merge(arr, l, mid, r); //合并排序过程
        return (left + right + count) % 1000000007;
    }

    /**
     * 从后开始合并有序数组
     * @param arr
     * @param l
     * @param m
     * @param r
     * @return
     */
    public static int merge(int[] arr, int l, int m, int r) {
        //辅助数组，注意数组长度
        int[] help = new int[r - l + 1];
        int i = help.length - 1;
        int p1 = m;
        int p2 = r;
        int count = 0;
        while (p1 >= l && p2 > m) {
            //前面比后面大
            if (arr[p1] > arr[p2]) {
                help[i--] = arr[p1--];
                //逆序数为：从开始到当前数的个数
                count = count + (p2 - m);
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
            } else
                help[i--] = arr[p2--];
        }
        //p1有剩余，因为是大的先走，剩下的都是小的，所以不存在逆序对
        while (p1 >= l) {
            help[i--] = arr[p1--];
        }
        //p2有剩余，p1都走没了，还有啥逆序对
        while (p2 > m) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return count;
    }
}
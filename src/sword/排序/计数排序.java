package sword.排序;

/**
 * @author yuyang
 * @create 2019-08-09 9:51
 */
public class 计数排序 {
    // only for 0~200 value
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //定义最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //设置容器：个数为桶个数加1
        int[] bucket = new int[max + 1];
        //每出现一次就向bucket中相应位置加1
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        //从容器中倒出的过程
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}

package sword.数组;

/**
 * 二分思想：非减序列不能使用这种方法：开始、中间、结尾元素相等无法判断
 *
 * @author yuyang
 * @create 2019-08-11 10:00
 */
public class f旋转数组最小数字 {

    public int minNumberInRotateArray(int[] array) {
        //数组的边界(数组没有分配地址，分配地址，但是没有存储数据)
        if (array == null || array.length == 0) return 0;

        int l = 0;
        int r = array.length - 1;
        //二分查找肯定需要中间指针
        int m = l;
        while (l < r) {
            if (r - l == 1) {
                m = r;
                break;
            }
            m = (l + r) >> 1;
            //中间位置数字大于等于index1位置数字
            if (array[m] >= array[l])
                l = m;
            else if (array[m] <= array[r])
                r = m;
        }
        return array[m];
    }
}

package sword.数组;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * @author yuyang
 * @create 2019-08-11 10:09
 */
public class l连续子数组最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0) return 0;
        int sum = array[0];
        int maxSum = array[0];
        for(int i = 1; i < array.length; i++){
            //加和小于0,前面的就不用算了，从当前元素开始就可以
            if(sum < 0)
                sum = array[i];
            else
                sum += array[i];
            //每次加一个数都会比较一次，如果加了一个负数，maxSum依然是之前的，如果又加了正数变大会记录下来
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}

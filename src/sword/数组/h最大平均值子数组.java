package sword.数组;

/**
 * https://www.jianshu.com/p/51f9089c7f9f
 * 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且
 * 平均值最大。（最大平均值,不是最大值。因为得出最大值不一定能够推出最大的平均值，因为平均值不仅受和的影响，还要受个数影响。）
 * 给出 nums = [1, 12, -5, -6, 50, 3], k = 3
 * 返回 15.667 // (-6 + 50 + 3) / 3 = 15.667
 * @author yuyang
 * @create 2019-08-11 8:36
 */

/**
 * 1.使用二分法：二分的是数组中最大值与最小值，体会一下
 * 2.如果存在子数组平均值大于（最大值-最小值）/2,最大平均值在mid和最大值之间
 * 3.判断公式：(nums[i] + nums[i + 1] + ...... + nums[j]) / (i - j) >= mid
 * 4.怎么判断一个子数组(长度L >= k)和的平均值大于mid呢？
 * 5.网址中的递推公式得出：(数组中每一个数-mid)，然后求和，如果>0则，数组平均值大于mid
 */
public class h最大平均值子数组 {
    public static double maxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        //求出数组中最大值和最小值
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        //1e-6(也就是0.000001)叫做epslon，用来抵消浮点运算中因为误差造成的相等无法判断的情况。
        //最大值最小值不相等
        while (max - min >= 1e-6) {
            double mid = (max + min) / 2.0;
            if(binarySearch(nums, mid, k)){//表示最大的平均值在[min, mid]里面
                min = mid;
            }else{//表示最大的平均值在[mid, max]里面
                max = mid;
            }
        }
        return min;
    }

    private static boolean binarySearch(int[] nums, double mid, int k) {
        //用来记录区间和的
        double sum[] = new  double[nums.length + 1];
        double min = 0;
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            //计算每个点的区间和
            sum[i] = sum[i - 1] + (nums[i - 1] - mid);
            //min相当于是s[j]，不过这里是一步一步的取小值得出来的
            if (i >= k && sum[i] >= min) {//表示有b数组的和>=0，则取值范围变为[mid, max]
                return true;
            }  if (i >= k) {
                min = Math.min(min, sum[i - k + 1]); //一步一步的取小值
            }
        }
        return false;
    }
}

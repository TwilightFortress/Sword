package sword.数组;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author yuyang
 * @create 2019-08-11 10:13
 */

/**
 *
 */
public class e数组中重复的数字 {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int temp = 0;
        if(numbers == null ||length <= 0) return false;
        for(int i = 0; i < length; i++){
            if(numbers[i] <= 0 || numbers[i] > length - 1)
                return false;
        }
        int l = 1;
        int r = length - 1;
        int m = l;
        while(l <= r){
            int count = 0;
            //0-n-1位与中间的数的个数
            m = l + ((r - l) >> 1);
            // m = (r + l)/2;
            for(int i = 0; i < length; i++){
                if(numbers[i] >= l && numbers[i] <= m){
                    count++;
                }
            }

            //最后二分到最后两个指针指向多的数
            if(l == r){
                if(count > 1)
                    duplication[0] = numbers[l];
                return true;
            }
            //大于他说明这个数在l-m之间
            if(count > m - l + 1){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return false;
    }
}

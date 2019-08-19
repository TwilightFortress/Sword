package sword.烦人题;

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 * @author yuyang
 * @create 2019-08-07 10:42
 * https://www.cnblogs.com/yongh/p/9947165.html
 */

/**
 * 1.当前的位上的数字等于0时，例如n=21034，在百位上的数字cur=0， 当前为1的个数：high*100
 * 2.当前位的数字等于1时，例如n=21034，在千位上的数字cur=1，    当前为1的个数：high*1000+(low+1)
 * 3.当前位的数字大于1时，例如n=21034，在十位上的数字cur=3,    当前为1的个数：(high+1)*10
 */
public class g整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {  //i代表位数
            int high = n / (i * 10); //更高位数字
            int low = (n % i);  //更低位数字
            int cur = (n / i) % 10;  //当前位数字
            if (cur == 0) {
                count += high * i;
            } else if (cur == 1) {
                count += high * i + (low + 1);
            } else {
                count += (high + 1) * i;
            }
        }
        return count;
    }
}
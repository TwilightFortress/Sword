package sword.烦人题;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author yuyang
 * @create 2019-08-11 10:04
 */
public class c二进制中1的个数 {
    public int NumberOf1(int n) {

        int count = 0;
        while(n != 0){
            count++;
            //将最右边的1变成0，有多少1就会进行多少次此操作，最后n变成0
            n = n&(n - 1);
        }
        return count;
       // Integer a = null;

    }
}

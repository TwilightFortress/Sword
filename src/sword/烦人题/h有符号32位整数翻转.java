package sword.烦人题;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-10 22:07
 */

/**
 * 1.取最后一位，乘10，加上再取的最后一位
 */
public class h有符号32位整数翻转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            System.out.println(reverseNum(a));
        }
    }

    private static int reverseNum(int a) {
        int tmp = 0;
        while (a != 0) {
            //取最后一位
            int b = a % 10;
            //int范围：-2147483648——2147483647
            if ((tmp > Integer.MAX_VALUE / 10 || (tmp == Integer.MAX_VALUE / 10 && b > 7))
                    || tmp < Integer.MIN_VALUE / 10 || (tmp == Integer.MIN_VALUE / 10 && b < -8)) {
                return 0;
            }
            //最后一位*10增加
            tmp = tmp * 10 + b;
            //取最后第二位
            a /= 10;
        }
        return tmp;
    }
}

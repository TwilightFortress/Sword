package sword.烦人题;

/**
 * @author yuyang
 * @create 2019-08-07 10:20
 * 考虑大数问题
 * 使用字符串，模拟加法，从1一直加到最后
 */
public class i打印从1到n最大的n位数 {
    public static void print1ToMaxOfNDights1s(int n) {
        if (n <= 0)
            return;
        //表示打印数字的字符串，初始化为0
        char[] digit = new char[n];
        for (int i = 0; i < n; i++)
            digit[i] = '0';

        for (int i = n - 1; i >= 0; i--) {
            //一直循环到最后一位为9
            while (digit[i] != '9') {
                //每次打印都是从m=0开始加
                int m = 0;
                digit[m]++;
                while (m < n - 1 && digit[m] > '9') {
                    digit[m] = '0';
                    digit[m + 1]++;
                    m++;
                }
                printdigits(digit);
            }
        }
    }

    //打印函数，前面是0的时候，需要把0去掉
    private static void printdigits(char[] digit) {
        int m = digit.length - 1;
        while (digit[m] == '0')
            m--;
        for (int i = m; i >= 0; i--)
            System.out.print(digit[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDights1s(5);
    }
}


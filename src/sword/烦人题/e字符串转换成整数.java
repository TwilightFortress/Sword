package sword.烦人题;

/**
 * 把一个字符串转化成整数（不是一个完全符合规则的字符串，需要考虑+、-）
 * 思路：从头开始转化，转化一个之后，扩大10倍加上下一个转化的。
 * 1.考虑字符串的正负。
 * 2.考虑每个字符是否在‘0’-‘9’之间
 * 3.考虑这个数是否在int区间
 * @author yuyang
 * @create 2019-08-11 9:56
 */
public class e字符串转换成整数 {
    static boolean isValid = false;
    public int StrToInt(String str) {
        //字符串为空
        if (str == null || str.length() <= 0)
            return 0;
        char[] chars = str.toCharArray();
        long num = 0;  //先用long来存储，以防止越界
        //控制字符的正负
        boolean minus = false;
        for (int i = 0; i < chars.length; i++) {
            //只有第一个字符，才能是正负号
            if (i == 0 && chars[i] == '-') {
                minus = true;
            } else if (i == 0 && chars[i] == '+') {
                minus = false;
            } else {
                //将字符转化为int
                int a = (int) (chars[i] - '0');
                //非法字符的判断
                if (a < 0 || a > 9) {
                    isValid = false;
                    return 0;
                }
                //正数高位扩大10倍加上当前数，负数扩大10倍减去当前数
                num = (minus == false) ? num * 10 + a : num * 10 - a;
                isValid = true;  //不放在最后面是为了防止str=‘+’的情况被判断为true
                //int类型最大正整数为0x7FFFFFFF，最小负整数为0x80000000。
                if ((!minus && num > 0x7FFFFFFF)
                        || (minus && num < 0x80000000)) {
                    isValid = false;
                    return 0;
                }
            }
        }
        return (int) num;
    }
}

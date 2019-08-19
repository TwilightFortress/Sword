package sword.字符串;

/**
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 原：abcXYZdef,
 * 中：cbafedZYX，根据给定位数，分别旋转两部分
 * 后：XYZdefabc, 整体旋转
 * @author yuyang
 * @create 2019-08-08 13:33
 */
public class d左旋转字符串 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() <= 0)
            return str;
        if (n <= 0 || n > str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
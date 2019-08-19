package sword.字符串;

/**
 * 原字符串：       I am a students.
 * 1.先全翻转：     .stneduts a ma I
 * 按照单词转回来： students. a am I
 *
 * @author yuyang
 * @create 2019-08-08 13:35
 */
public class c翻转单词顺序 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() <= 0)
            return str;
        char[] chars = str.toCharArray();
        //翻转整个句子
        reverseSb(chars, 0, chars.length - 1);
        /**
         * 俩个指针：l,r
         * 1.起始都是0，r先走，走到空格
         * 2.翻转l到 r - 1
         * 3.l = r + 1; r ++;跳过这个空格继续
         */
        int l = 0;
        int r = 0;
        while (l < chars.length) {
            while (r < chars.length && chars[r] != ' ')
                r++;
            reverseSb(chars, l, r - 1);
            l = ++r;
        }
        return String.valueOf(chars);
    }

    /**
     * 翻转过程，首尾指针，交换，向前移动。
     *
     * @param chars
     * @param l
     * @param r
     */
    private void reverseSb(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}

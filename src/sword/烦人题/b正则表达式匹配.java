package sword.烦人题;

/**
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 * @author yuyang
 * @create 2019-08-07 10:35
 */

/**
 * (1)当模式中第二个字符不为“*”时：若当前字符相等，则字符串和模式都后移一个字符，继续调用函数进行比较；若不相等，则返回false。 aa,aa
 * (2)当模式中第二个字符为“*”时：若当前字符不相等，则模式后移两个字符，继续比较；ba a*ba
 *                            若当前字符相等，则有三种情况：
 *     1）字符串字符位置不变，模式后移两个字符，继续比较； a  a*a
 *   　2）字符串后移一个字符，模式后移两个字符，继续比较； aa  a*a
 *    3）字符串后移一个字符，模式字符位置不变，继续比较。  aa  a*
 * 　三种情况使用“||”进行并列比较。
 */
public class b正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int indexOfStr, char[] pattern, int indexOfPattern) {
        //同时移到末尾，匹配
        if (indexOfStr == str.length && indexOfPattern == pattern.length)
            return true;
        if (indexOfStr < str.length && indexOfPattern == pattern.length)
            return false;

        //模式下一位为*
        if (indexOfPattern + 1 < pattern.length && pattern[indexOfPattern + 1] == '*') {
             //当前为相等
            if ((indexOfStr < str.length && pattern[indexOfPattern] == '.')
                    || (indexOfStr < str.length && pattern[indexOfPattern] == str[indexOfStr])) {
                                //模式后移两位
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2)
                                //字符串后移一位
                        || matchCore(str, indexOfStr + 1, pattern, indexOfPattern)
                                    //字符串后移一位，模式后移两位
                        || matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 2);
            } else {
                //不相等：模式后移两位
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2);
            }
        }
        //当前位相等，双双后移
        if (indexOfStr < str.length && (pattern[indexOfPattern] == str[indexOfStr] || pattern[indexOfPattern] == '.'))
            return matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 1);
        return false;
    }
}

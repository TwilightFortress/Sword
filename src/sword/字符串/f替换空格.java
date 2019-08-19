package sword.字符串;

/**
 * @author yuyang
 * @create 2019-08-11 9:57
 */
public class f替换空格 {
    public String replaceSpace(StringBuffer str) {

        //2.遍历一遍字符串统计出字符串长度，空格个数；
        int originalLength = str.length();
        if(originalLength == 0) return str.toString();
        int numberOfBlank = 0;
        int i = 0;
        while (i < originalLength) {
            if (str.charAt(i) == ' ')
                numberOfBlank++;
            i++;
        }
        if(numberOfBlank == 0)
            return str.toString();
        //3.算出新长度，定义两个指针；
        int newLength = originalLength + numberOfBlank * 2;
        int indexOfOriginal = originalLength;
        int indexOfNew = newLength;
        //4.设置新的字符串长度
        str.setLength(newLength);
        //移动字符串
        while (indexOfOriginal >= 0 && indexOfNew >= indexOfOriginal) {
            if (str.charAt(indexOfOriginal) == ' ') {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }else
                str.setCharAt(--indexOfNew, str.charAt(--indexOfOriginal));
        }

        return str.toString();
    }
}

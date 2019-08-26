package sword.字符串;

/**
 * @author yuyang
 * @create 2019-08-11 9:57
 */
public class f替换空格 {
    public static String replaceSpace(StringBuffer str) {

        //2.遍历一遍字符串统计出字符串长度，空格个数；
        int len = str.length();
        if (len == 0) return str.toString();
        int num = 0;
        int i = 0;
        while (i < len) {
            if (str.charAt(i) == ' ')
                num++;
            i++;
        }
        if (num == 0)
            return str.toString();
        //3.算出新长度，定义两个指针；
        int len1 = len + num * 2;
        int index = len - 1;
        int index1 = len1 - 1;
        //4.设置新的字符串长度
        str.setLength(len1);
        //移动字符串
        while (index >= 0 && index1 >= index) {
            if(str.charAt(index) != ' '){
                str.setCharAt(index1--, str.charAt(index));
            }else{
                str.setCharAt(index1--, '0');
                str.setCharAt(index1--, '2');
                str.setCharAt(index1--, '%');
            }
            index--;
        }
        return str.toString();
    }

    //简单的方法替换空格
    public static String fun(String str) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
                i++;
            } else {
                sb.append(str.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
        String str1 = "We are Happy";
        System.out.println(fun(str1));
    }
}

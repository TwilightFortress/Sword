package sword.字符串;

/**
 * @author yuyang
 * @create 2019-08-26 21:22
 *
 */
public class 替换字符串中的816 {
    public static void main(String[] args) {
        String str = "81881616";
        fun(str);
    }
    public static void fun(String str){
        String str1 = str.replaceAll("816", "");
        String str2 = str1.replaceAll("816", "");
        while(!str1.equals(str2)){
            str1 = str2.replaceAll("816", "");
            str2 = str1.replaceAll("816", "");
        }
        System.out.println(str2);
    }
}

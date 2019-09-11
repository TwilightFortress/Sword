package sword.字符串;

/**
 * @author yuyang
 * @create 2019-09-08 18:00
 */
public class 字符串去重 {
    public static String removeRepeatChar(String str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {

            char charWord = str.charAt(i);

            int firstPosition = str.indexOf(charWord);

            int lastPosition = str.lastIndexOf(charWord);

            if (firstPosition == lastPosition || firstPosition == i) {

                sb.append(charWord);

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hellohikvision";
        System.out.println(removeRepeatChar(str));
    }
}

package sword.字符串;

/**
 * @author yuyang
 * @create 2019-08-26 21:22
 */
public class 替换字符串中的816 {
    /**
     * API版本
     * @param str
     */
    public static void fun(String str) {
        String str1 = str.replaceAll("816", "");
        String str2 = str1.replaceAll("816", "");
        while (!str1.equals(str2)) {
            str1 = str2.replaceAll("816", "");
            str2 = str1.replaceAll("816", "");
        }
        System.out.println(str2);
    }


    /**
     * 不用API版本
     * @param chars
     * @return
     */
    public static String replace816(char[] chars) {
        boolean b = true;
        int[] arr = new int[chars.length];
        while (b) {
            for (int i = 0; i < chars.length; i++) {
                int k = i;
                while(k < chars.length - 1){
                    if(arr[++k] == 1){}
                    else break;
                }
                if (k < chars.length && k + 1 < chars.length && chars[i] == '8' && chars[k] == '1' && chars[k + 1] == '6') {
                    arr[i] = 1;
                    arr[k] = 1;
                    arr[k + 1] = 1;
                    b = false;
                }
            }
            if (b == false) b = true;
            else {
                b = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (arr[i] != 1) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "81881616";
        char[] chars = str.toCharArray();
        // fun(str);
        System.out.println(replace816(chars));
    }
}

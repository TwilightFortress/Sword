package others;

/**
 * 删除字符串中m个连续的0
 * "B000C00" m = 3 :"BC00"
 * "B000C00" m = 2 :"B000C"
 *
 * @author yuyang
 * @create 2019-08-17 14:28
 */
public class 删除字符串中m个0 {

    public static void main(String[] args) {

        String str = "B000C00";
        String str1 = fun(str.toCharArray(), 3);
        System.out.println(str1);
    }

    public static String fun(char[] chars, int m) {

        //标记要被删除的字符下标
        int[] arr = new int[chars.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < chars.length; ) {
            boolean b = true;
            if (i <= chars.length - m) {
                for (int j = i; j < m + i; j++) {
                    if (chars[j] != '0') {
                        b = false;
                        break;
                    }
                }
                //当前位置开始连着m个0
                if (b == true) {
                    //下一个位置还是0不能标记
                    if (i + m < chars.length && chars[i + m] == '0') {
                        i = i + m + 1;
                    } else {
                        //下一个位置不是0，标记
                        for (int k = i; k < m + i; k++) {
                            arr[k] = 1;
                        }
                        i = i + m;
                    }

                    //没有连着m个0的情况
                } else {
                    i++;
                }
                //找完退出
            } else {
                break;
            }
        }
        String str1 = new String();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                str1 += chars[i];
            }
        }
        return str1;
    }
}


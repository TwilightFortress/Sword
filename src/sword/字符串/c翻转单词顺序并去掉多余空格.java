package sword.字符串;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-18 15:39
 */
public class c翻转单词顺序并去掉多余空格 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.replaceAll(" {2,}", " ").split(" ");
        int num = str1.length;
        StringBuffer sb = new StringBuffer();
        for (int i = num - 1; i > 0 ; i--) {
            sb.append(str1[i]).append(" ");
        }
        sb.append(str1[0]);
        System.out.println(sb.toString());
    }
}

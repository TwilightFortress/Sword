package sword.字符串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *单个字符串的最长公共子串
 * @author yuyang
 * @create 2019-09-02 20:27
 */
public class 单个字符串的最长公共子串 {
    //保存最长公共子串
    static String result = "";

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> list = new ArrayList<String>();
        //得到字符串的所有后缀
        for (int i = s.length() - 1; i >= 0; i--) {
            list.add(s.substring(i));
        }
        Collections.sort(list);
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len = getComlen(list.get(i), list.get(i + 1));
            maxLen = Math.max(maxLen, len);
        }
        System.out.println(result + ":" + maxLen);
    }

    //得到两个字符串最长公共长度
    public static int getComlen(String str1, String str2) {
        int i;
        for (i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        String temp = str1.substring(0, i);
        if (temp.length() > result.length()) result = temp;
        return i;
    }

}

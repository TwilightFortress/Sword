package others;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-10 20:23
 */
public class 递归下降分析器 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            fun(chars);
    }

    private static void fun(char[] chars) {
        int num = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*'){
                stringBuffer.append("TF");
                if (chars[i + 1] == '*') {
                    System.out.println("false");
                    num = 1;
                    break;
                }
            }
            if(chars[i] == '+'){
                stringBuffer.append("ETF");
            }
        }

        if(num == 0){
            System.out.print("true ETF");
            System.out.print(stringBuffer);
        }
        System.out.println();
    }
}

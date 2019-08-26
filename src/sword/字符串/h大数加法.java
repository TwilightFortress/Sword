package sword.字符串;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-23 10:34
 */
public class h大数加法 {

    /**
     * 整数API
     * @param a
     * @param b
     */
    public static void fun(String a, String b){
        BigDecimal a1 = new BigDecimal(a);
        BigDecimal b1 = new BigDecimal(b);
        System.out.println(a1.add(b1));
    }
    /**
     * 浮点数API
     */
    public static void fun1(String a, String b){
        BigDecimal a1 = new BigDecimal(String.valueOf(a));
        BigDecimal b1 = new BigDecimal(String.valueOf(b));
        System.out.println(a1.subtract(b1));

    }

    public static void main(String[] args) {
        String a = "4325425436547568657543543";
        String b = "35423543645735423432154643";
        fun(a, b);
        System.out.println("---------------");
        double d1 = 2.0;
        double d2 = 1.1;
        System.out.println(d1 - d2);
        fun1(String.valueOf(d1), String.valueOf(d2));
    }
}

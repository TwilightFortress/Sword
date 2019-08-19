package test;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-18 16:54
 */
public class test6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int t = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[2]);
        String[] str1 = sc.nextLine().split(" ");
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += Integer.parseInt(str1[i]);
        }
        System.out.println((int)Math.ceil(((double)(tmp - t + m)/m)));
    }
}

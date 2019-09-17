package others.公司笔试题;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-16 14:52
 */
public class 咪咕_判断是这一年的第几天 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        int sum = 0;
        int[][] a = {
                {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };
        for (int i = 0; i < month - 1; i++) {
            if (year % 4 == 0 & year % 100 != 0 | year % 400 == 0)
                sum = sum + a[1][i];
            else
                sum = sum + a[0][i];
        }
        sum = sum + day;
        System.out.println(sum);
    }
}

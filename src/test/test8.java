package test;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-24 20:47
 */
public class test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, h[i]);
            if(h[i] <= h[i + 1] && h[i + 1] >= max) res++;
        }
        System.out.println(res + 1);
    }
}

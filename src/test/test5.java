package test;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-24 16:27
 */
public class test5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        fun(n, m, arr);
    }
    public static void fun(int n, int m, int[] arr) {
        int j = 0;
        while(j < n) {
            int k = j + 1;
            while (k < n && arr[j] == arr[k]) {
                k++;
            }
            int len = k - j;
            if (len > m) {
                j = j + len;
            } else if (len <= m) {
                System.out.print(arr[j] + " ");
                j++;
            }
        }
    }
}

package others.公司笔试题;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-12 16:21
 * 有问题
 */
/*
2
-1 2 -3 6
 */
public class 二维数组最大子数组和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        if(str1 == null || str1.length() <=0) return;
        int n = Integer.parseInt(str1);
        String[] str = sc.nextLine().split(" ");
        int[][] arr = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[k]);
                k++;
            }
        }
        int num = fun(arr, n);
        System.out.println(num);
    }

    private static int fun(int[][] arr, int n) {
        int max = 0;
        int tmp;
        int min = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                min = arr[i][j] < arr[0][0] ? arr[i][j] : arr[0][0];
                tmp = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l <= j + i; l++) {
                        tmp = tmp + arr[l][k];
                    }
                    if(tmp < 0){
                        tmp = 0;
                    }
                    if(max < tmp){
                        max = tmp;
                    }
                }
            }
        }
        if(max == 0 && min != 0)
            return min;
        return max;
    }
}

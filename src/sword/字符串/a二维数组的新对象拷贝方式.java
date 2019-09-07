package sword.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-01 20:15
 */
/*
3
1 3
1 1
4 1
 */

public class a二维数组的新对象拷贝方式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        ArrayList<int[][]> list = new ArrayList<>();
        fun1(arr, 0, n, list);
        int k = list.size(), min = Integer.MAX_VALUE;//一共有多少种数组
        for (int i = 0; i < k; i++) {
            min = Math.min(min, fun3(list.get(i), n));
        }
        System.out.println(min);
    }


    private static void fun1(int[][] arr, int i, int n, ArrayList<int[][]> listAll) {
        if (i == arr.length - 1) {
            int[][] arr1 = new int[n][2];
            for (int j = 0; j < n; j++) {
                arr1[j] = Arrays.copyOf(arr[j], arr[j].length);
            }
            listAll.add(arr1);
        } else
            for (int j = i; j < n; j++) {
                swap(arr, i, j);//交换元素
                fun1(arr, i + 1, n, listAll);
                swap(arr, i, j);
            }
    }
        private static void swap(int[][] arr, int i, int j) {
        int tmp1 = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = tmp1;
        int tmp2 = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = tmp2;
    }
    /*
    根据重新排序的数组计算愤怒值总和
     */
    public static int fun3(int[][] arr, int n) {

        int num = 0;
        for (int i = 0; i < n; i++) {
            int k = i + 2;
            if(i + 2 > 0){
                k = 0;
            }
            num += arr[i][0] * i + arr[i][1] *( n - i - 1);
        }
        return num;
    }
}























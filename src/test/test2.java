package test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-29 20:17
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] arr1 = str1.split(" ");
        int n = Integer.parseInt(arr1[0]);
        int m = Integer.parseInt(arr1[1]);
        int k = Integer.parseInt(arr1[2]);
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        fun(n, m, k, arr);
    }

    private static void fun(int n, int m, int k, int[][] arr) {
        //1.最多情况为人数-1
        //2.数组中有几组重复的数就减几
        int num1 = fun1(arr);
        int num2 = 0;
        //3.每组之间还可以减1
        if(num1 > 2){
            num2 = num1/2 + 1;
        }

        int num = m - 1 - num1 - num2;
        System.out.println(num);
    }

    private static int fun1(int[][] arr) {
        int num = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i][1])){
                num++;
            }else{
                map.put(arr[i][1],0);
            }
        }
        return num;
    }
}

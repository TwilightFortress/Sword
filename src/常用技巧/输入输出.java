package 常用技巧;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-11 17:47
 */
public class 输入输出 {

    /**
     * 输入数组，数组中元素个数不知道
     */
    public static void test1() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String[] st2 = st.split(" ");
        int[] arr = new int[st2.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st2[i]);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 先输入数组元素个数，再输入数组
     */
    public static void test2() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 输入矩阵
     */
    public static void test3() {

        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2][1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 输入一行字符串，按照空格分隔成字符串数组
     */
    public static void test4() {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] str2 = str.split(" ");

            System.out.println(str2[str2.length - 1].length());
        }

    }

    /**
     * 第一行输入n个数字，第二行输入字符串
     */
    public static void test5() {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split(" ");
        //存储n个数字
        int[] arr = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            arr[i] = Integer.parseInt(str1[i]);
        }
        //存储字符串
        String str2 = sc.nextLine();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(str2);
    }

    //输入[1, 2, 3, 4, 5],使用数组存起来
    public static void test6(){
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String str = st.substring(1,st.length() - 1);
        String[] str2 = str.split(", ");
        int[] arr = new int[str2.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //输入数组，数组中元素个数不知道
        test1();
        //先输入数组元素个数，再输入数组
        test2();
        //输入矩阵
        test3();
        //输入一行字符串，按照空格分隔成字符串数组
        test4();
        //第一行输入n个数字，第二行输入字符串
        test5();
        //输入[1, 2, 3, 4, 5],使用数组存起来
        //test6();
    }
}

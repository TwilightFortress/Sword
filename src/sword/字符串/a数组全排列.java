package sword.字符串;

import java.util.ArrayList;
import java.util.Arrays;

import static sword.排序.快排.swap;

/**
 * @author yuyang
 * @create 2019-09-02 10:25
 */
public class a数组全排列 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<int[]> list = fun(arr);
        for (int[] ints : list) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<int[]> fun(int[] arr){
        ArrayList<int[]> list = new ArrayList<>();
        if(arr.length <= 0) return list;
        fun(arr, 0, list);
        return list;
    }

    private static void fun(int[] arr, int i, ArrayList<int[]> list) {
        if(i == arr.length - 1){
            list.add(Arrays.copyOf(arr, arr.length));
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            fun(arr, i + 1, list);
            swap(arr, i, j);
        }
    }
}

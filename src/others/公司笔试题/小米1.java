package others.公司笔试题;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-11 19:42
 */
/*
[4, 2, 7, 6]
[2, 4 ,6, 7]
 */
public class 小米1 {
    static int solution1(int[] arr) {
        int k1 = 0;
        if(arr == null || arr.length < 2) return 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--,k1++) {
                swap(arr, j , j + 1);
            }
        }
        return k1;
    }
    static int solution2(int[] arr){
        if(arr == null || arr.length < 2) return 0;
        int k2 = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 && arr[j] < arr[j + 1] ; j--,k2++) {
                swap(arr, j, j + 1);
            }
        }
        return k2;
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res1, res2;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int[] _arr1 = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
            _arr1[_arr_i] = _arr_item;
        }
        res1 = solution1(_arr);
        res2 = solution2(_arr1);
        int res = res1 < res2 ? res1 : res2;
        System.out.println(String.valueOf(res));

    }
}

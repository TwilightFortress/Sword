package sword.数组;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 返回数组中和为0的对数
 * @author yuyang
 * @create 2019-09-03 16:45
 */
public class 返回数组中和为0的对数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replaceAll("\\s*", "");
        String[] arrStr = str.split(",");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int k = pair(arr);
        System.out.println(k);

    }

    public static int pair(int[] arr){
        Arrays.sort(arr);
        int k = 0;
        int l = 0, r = arr.length - 1;
        while(l < r){
            if(arr[l] + arr[r] == 0){
                k++;
                l++;
                r--;
            }else if(arr[l] + arr[r] < 0){
                l++;
            }else{
                r--;
            }
        }

        return k;
    }
}

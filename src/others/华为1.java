package others;

import java.util.Scanner;

/**
 *
 * @author yuyang
 * @create 2019-09-07 19:03
 */
public class 华为1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int res = fun(arr);
        System.out.println(res);
    }
    public static int fun(int[] arr){

        int num = Integer.MAX_VALUE;
        int k = 1;
        int len = arr.length;
        //1计算每个第一步可达位置
        for (int i = 1; i < len/2; i++) {
            //2从每一个可达位置计算是否能够到达末尾
            int j = i;
            k = 1;
            while(j < len - 1){
                j = j + arr[j];
                k++;
            }
            if(j == len - 1){
                num = Math.min(num, k);
            }
        }
        if(num == Integer.MAX_VALUE){
            return -1;
        }else
            return num;
    }
}

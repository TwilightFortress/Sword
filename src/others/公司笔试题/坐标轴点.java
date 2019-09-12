package others.公司笔试题;

import java.util.Arrays;

/**
 * 数轴上n个点，从0个点走到n-1个点，有一个点可以忽略，求最短距离。
 * @author yuyang
 * @create 2019-08-20 15:18
 * 数组遍历用了两个指针，越过其中的点。
 */
public class 坐标轴点 {
    public static void main(String[] args) {
        int[] arr = {1,4,-1,3};
        System.out.println(fun(arr));
    }

    public static int fun(int[] arr){
        int num1 = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            int num = 0;
            for(int j = 0,k = 1; k < arr.length; k++){
                if(k == i)
                    continue;
                num += Math.abs(arr[j] - arr[k]);
                j = k;

            }
            num1 = Math.min(num, num1);
        }
        return num1;

    }
}

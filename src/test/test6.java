package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-24 17:06
 */
public class test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(getMax(arr));
        }
    }

    private static void fun7(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public  static int getMax(int[] nums){
        int max = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >=2 ; i -= 3) {
            int min = Math.min(Math.min(nums[i] , nums[i - 1]), nums[i - 2]);
            max += min;
        }
        return max;
    }
}

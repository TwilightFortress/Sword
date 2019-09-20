package others.公司笔试题;


import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-16 20:59
 * ac 100%
 */
public class 五八_笔试题3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr1[i] = arr[i - 1] < arr[i] ? arr1[i - 1] + 1 : 1;
        }
        for (int j = n; j > 0; j--) {
            arr2[j] = arr[j] < arr[j + 1] ? arr2[j + 1] + 1 : 1;
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, arr1[i - 1] + 1);
            res = Math.max(res, arr2[i + 1] + 1);
            if (arr[i + 1] - arr[i - 1] >= 2) {
                res = Math.max(res, arr1[i - 1] + arr2[i + 1] + 1);
            }
        }
        System.out.println(res);
    }
}
